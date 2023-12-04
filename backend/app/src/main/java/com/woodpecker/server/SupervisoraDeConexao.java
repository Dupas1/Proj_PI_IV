package com.woodpecker.server;

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.util.*;

public class SupervisoraDeConexao extends Thread
{
    private double              valor=0;
    private Partner usuario;
    private Socket              conexao;
    private ArrayList<Partner> usuarios;
    private String difficulty;
    private int numberReview;

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

        ObjectOutputStream transmissor;
        try
        {
            transmissor =
                    new ObjectOutputStream(
                            this.conexao.getOutputStream());
        }
        catch (Exception erro)
        {
            return;
        }

        ObjectInputStream receptor=null;
        try
        {
            receptor=
                    new ObjectInputStream(
                            this.conexao.getInputStream());
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

        try
        {
            synchronized (this.usuarios)
            {
                this.usuarios.add (this.usuario);
            }

            for(;;)
            {
                Order order = this.usuario.envie ();

                if (order==null)
                    return;
                else if (order instanceof CalculationReviewOrder)
                {
                    CalculationReviewOrder calculationReviewOrder = (CalculationReviewOrder) order;

                    if (calculationReviewOrder.getDificulty() == "BEGIN")
                    {
                        this.difficulty = calculationReviewOrder.getDificulty();
                        this.numberReview = calculationReviewOrder.getNumberReview();
                        ResultReview resultReview = new ResultReview();
                        LocalDate date = LocalDate.now().plusDays(5);
                        resultReview.setFinalDate(date);

                        this.usuario.receba(resultReview);
                        break;
                    }
                    else if(calculationReviewOrder.getDificulty() == "EASY")
                    {
                        this.difficulty = calculationReviewOrder.getDificulty();
                        this.numberReview = calculationReviewOrder.getNumberReview();
                        ResultReview resultReview = new ResultReview();
                        LocalDate date = LocalDate.now().plusDays(15);
                        resultReview.setFinalDate(date);

                        this.usuario.receba(resultReview);
                        break;
                    }
                    else if(calculationReviewOrder.getDificulty() == "MEDIUM")
                    {
                        this.difficulty = calculationReviewOrder.getDificulty();
                        this.numberReview = calculationReviewOrder.getNumberReview();
                        ResultReview resultReview = new ResultReview();
                        LocalDate date = LocalDate.now().plusDays(10);
                        resultReview.setFinalDate(date);

                        this.usuario.receba(resultReview);
                        break;
                    }
                    else if(calculationReviewOrder.getDificulty() == "HARD")
                    {
                        this.difficulty = calculationReviewOrder.getDificulty();
                        this.numberReview = calculationReviewOrder.getNumberReview();
                        ResultReview resultReview = new ResultReview();
                        LocalDate date = LocalDate.now().plusDays(5);
                        resultReview.setFinalDate(date);

                        this.usuario.receba(resultReview);
                        break;
                    }
                    else {

                        this.difficulty = calculationReviewOrder.getDificulty();
                        this.numberReview = calculationReviewOrder.getNumberReview();
                        ResultReview resultReview = new ResultReview();
                        LocalDate date = LocalDate.now().plusDays(1);
                        resultReview.setFinalDate(date);

                        this.usuario.receba(resultReview);
                        break;

                    }
                }
                else if (order instanceof ExitOrder)
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

