package com.woodpecker.backend.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class Partner {
    private Socket conexao;
    private ObjectInputStream receptor;
    private ObjectOutputStream transmissor;

    private Order currentOrder =null;

    private Semaphore mutEx = new Semaphore (1,true);

    public Partner(Socket conexao, ObjectInputStream  receptor, ObjectOutputStream transmissor) throws Exception // se parametro nulos
    {
        if (conexao==null)
            throw new Exception ("Conexao ausente");

        if (receptor==null)
            throw new Exception ("Receptor ausente");

        if (transmissor==null)
            throw new Exception ("Transmissor ausente");

        this.conexao = conexao;
        this.receptor = receptor;
        this.transmissor = transmissor;
    }

    public void receba (Order x) throws Exception
    {
        try
        {
            this.transmissor.writeObject (x);
            this.transmissor.flush();
        }
        catch (IOException erro)
        {
            throw new Exception ("Erro de transmissao");
        }
    }

    public Order espie () throws Exception
    {
        try
        {
            this.mutEx.acquireUninterruptibly();
            if (this.currentOrder ==null) this.currentOrder = (Order)this.receptor.readObject();
            this.mutEx.release();
            return this.currentOrder;
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de recepcao");
        }
    }

    public Order envie () throws Exception
    {
        try
        {
            if (this.currentOrder ==null) this.currentOrder = (Order)this.receptor.readObject();
            Order ret = this.currentOrder;
            this.currentOrder = null;
            return ret;
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de recepcao");
        }
    }

    public void adeus () throws Exception
    {
        try
        {
            this.transmissor.close();
            this.receptor.close();
            this.conexao.close();
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de desconexao");
        }
    }
}
