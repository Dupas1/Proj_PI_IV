package Servidor;

import java.io.*;
import java.net.*;
import java.util.*;

public class SupervisoraDeConexao extends Thread
{
    private int numberReview;
    private String difficulty;
    private Parceiro usuario;
    private Socket conexao;
    private ArrayList<Parceiro> usuarios;

    public SupervisoraDeConexao(Socket conexao, ArrayList<Parceiro> usuarios) throws Exception
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
                    new ObjectInputStream(this.conexao.getInputStream());
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
            this.usuario = new Parceiro (this.conexao, receptor, transmissor);
        }
        catch (Exception erro)
        {} // sei que passei os parametros corretos

        try
        {
            synchronized (this.usuarios)
            {
                this.usuarios.add (this.usuario);
            }


            for(;;) // essa parte sera alterada para a contrução do servidor
            {
                Comunicado comunicado = this.usuario.envie (); // recebe do cliente

                if (comunicado==null)
                    return;
                else if (comunicado instanceof PedidoDeCalculoDeRevisao)
                {
                    PedidoDeCalculoDeRevisao calculo = (PedidoDeCalculoDeRevisao)comunicado;

                    if (calculo.getDificulty() == "BEGIN")
                    {
                        this.difficulty = calculo.getDificulty();
                        this.numberReview = calculo.getNumberReview();
                        Resultado x = new Resultado();

                        x.setValorResultante(1);

                        this.usuario.receba(x);
                        break;
                    }
                    else if(calculo.getDificulty() == "EASY")
                    {
                        this.difficulty = calculo.getDificulty();
                        this.numberReview = calculo.getNumberReview();
                        System.out.println(2);
                        break;
                    }
                    else if(calculo.getDificulty() == "MEDIUM")
                    {
                        this.difficulty = calculo.getDificulty();
                        this.numberReview = calculo.getNumberReview();
                        System.out.println(3);
                        break;
                    }
                    else if(calculo.getDificulty() == "HARD")
                    {
                        this.difficulty = calculo.getDificulty();
                        this.numberReview = calculo.getNumberReview();
                        System.out.println(4);
                        break;
                    }
                    else {

                        this.difficulty = calculo.getDificulty();
                        this.numberReview = calculo.getNumberReview();
                        System.out.println("WRONG");
                        break;

                    }



                }

                else if (comunicado instanceof PedidoParaSair)
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