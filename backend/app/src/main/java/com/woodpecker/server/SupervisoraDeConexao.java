package com.woodpecker.server;

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.util.*;
import  com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.woodpecker.LocalDateAdapter;

public class SupervisoraDeConexao extends Thread
{
    private Partner usuario;
    private Socket              conexao;
    private ArrayList<Partner> usuarios;


    public SupervisoraDeConexao
            (Socket conexao, ArrayList<Partner> usuarios)
            throws Exception
    {
        if (conexao==null)
            throw new Exception ("Conexao ausente");

        if (usuarios==null)
            throw new Exception ("Usuarios ausentes");

        this.conexao  = conexao;
        this.usuarios = usuarios;
    }

    public void run ()
    {

        PrintWriter transmissor;
        try
        {
            transmissor =
                    new PrintWriter(
                            this.conexao.getOutputStream());
        }
        catch (Exception erro)
        {
            return;
        }

        BufferedReader receptor=null;
        try
        {
            receptor=
                    new BufferedReader( new InputStreamReader(this.conexao.getInputStream()));
        }
        catch (Exception err0)
        {
            try
            {
                transmissor.close();
            }
            catch (Exception falha)
            {} // so tentando fechar antes de acabar a thread

            return;
        }

        try
        {
            this.usuario =
                    new Partner(this.conexao,
                            receptor,
                            transmissor);
        }
        catch (Exception erro)
        {} // sei que passei os parametros corretos

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        try
        {
            synchronized (this.usuarios)
            {
                this.usuarios.add (this.usuario);
            }

            for(;;)
            {
                String jsonOrder = this.usuario.envie();
                Order order = gson.fromJson(jsonOrder,Order.class);

                if (order==null)
                    return;
                else if (order.getOrderName().equals("CalculationReviewOrder"))
                {
                    CalculationReviewOrder calculationReviewOrder = gson.fromJson(jsonOrder,CalculationReviewOrder.class);
                    if (calculationReviewOrder.getDifficulty() == "BEGIN")
                    {
                        ResultReview resultReview = new ResultReview();
                        LocalDate date = LocalDate.now().plusDays(5);
                        resultReview.setFinalDate(date);
                        resultReview.setNumberReview(calculationReviewOrder.getNumberReview()+1);

                        this.usuario.receba(gson.toJson(resultReview));
                        break;
                    }
                    else if(calculationReviewOrder.getDifficulty().equals("EASY"))
                    {
                        ResultReview resultReview = new ResultReview();
                        LocalDate date = LocalDate.now().plusDays(5*calculationReviewOrder.getNumberReview());
                        resultReview.setFinalDate(date);
                        resultReview.setNumberReview(calculationReviewOrder.getNumberReview()+1);

                        this.usuario.receba(gson.toJson(resultReview));
                        break;
                    }
                    else if(calculationReviewOrder.getDifficulty().equals("MEDIUM"))
                    {
                        ResultReview resultReview = new ResultReview();
                        LocalDate date = LocalDate.now().plusDays(10);
                        resultReview.setFinalDate(date);
                        resultReview.setNumberReview(calculationReviewOrder.getNumberReview()+1);

                        this.usuario.receba(gson.toJson(resultReview));
                        break;
                    }
                    else if(calculationReviewOrder.getDifficulty().equals("HARD"))
                    {
                        ResultReview resultReview = new ResultReview();
                        LocalDate date = LocalDate.now().plusDays((long)(0.5* calculationReviewOrder.getNumberReview()));
                        resultReview.setFinalDate(date);
                        resultReview.setNumberReview(calculationReviewOrder.getNumberReview()+1);

                        this.usuario.receba(gson.toJson(resultReview));
                        break;
                    }
                    else {


                        ResultReview resultReview = new ResultReview();
                        LocalDate date = LocalDate.now().plusDays(1);
                        resultReview.setFinalDate(date);
                        resultReview.setNumberReview(0);

                        this.usuario.receba(gson.toJson(resultReview));
                        break;

                    }
                }
                else if (order.getOrderName().equals("ExitOrder"))
                {
                    synchronized (this.usuarios)
                    {
                        this.usuarios.remove (this.usuario);
                    }
                    this.usuario.adeus();
                }
            }
        }
        catch (Exception erro)
        {
            try
            {
                transmissor.close ();
                receptor   .close ();
            }
            catch (Exception falha)
            {} // so tentando fechar antes de acabar a thread

            return;
        }
    }
}

