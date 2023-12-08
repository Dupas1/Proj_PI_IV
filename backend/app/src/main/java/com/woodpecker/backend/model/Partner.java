package com.woodpecker.backend.model;


import com.woodpecker.backend.dtos.Order;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class Partner {
    private Socket             conexao;
    private BufferedReader receptor;
    private PrintWriter transmissor;

    private String currentOrder =null;

    private Semaphore mutEx = new Semaphore (1,true);

    public Partner(Socket             conexao,
                   BufferedReader  receptor,
                   PrintWriter transmissor)
            throws Exception // se parametro nulos
    {
        if (conexao==null)
            throw new Exception ("Conexao ausente");

        if (receptor==null)
            throw new Exception ("Receptor ausente");

        if (transmissor==null)
            throw new Exception ("Transmissor ausente");

        this.conexao     = conexao;
        this.receptor    = receptor;
        this.transmissor = transmissor;
    }

    public void receba (String x) throws Exception
    {
        this.transmissor.println (x);
        this.transmissor.flush       ();
    }

    public String espie () throws Exception
    {
        try
        {
            this.mutEx.acquireUninterruptibly();
            if (this.currentOrder ==null) this.currentOrder = this.receptor.readLine();
            this.mutEx.release();
            return this.currentOrder;
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de recepcao");
        }
    }

    public String envie () throws Exception
    {
        try
        {
            if (this.currentOrder ==null) this.currentOrder = this.receptor.readLine();
            String ret         = this.currentOrder;
            this.currentOrder = null;
            return ret;
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de recepcao: " + erro.getMessage());
        }
    }

    public void adeus () throws Exception
    {
        try
        {
            this.transmissor.close();
            this.receptor   .close();
            this.conexao    .close();
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de desconexao");
        }
    }
}
