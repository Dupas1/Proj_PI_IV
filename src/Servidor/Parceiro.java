package Servidor;

//representa algum cliente(pois tem varios). ou seja é oq se comunica com eles

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Semaphore;

public class Parceiro
{
    private Socket conexao;
    private ObjectInputStream  receptor;
    private ObjectOutputStream transmissor;
    private Comunicado proximoComunicado=null;//"espiar" o proximo comando

    private Semaphore mutEx = new Semaphore (1,true);//mutEx (mutua exclusão). 1 = um recurso

    public Parceiro (Socket conexao, ObjectInputStream receptor,ObjectOutputStream transmissor) throws Exception // se parametro nulos
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

    //envia -- faz o cliente receber
    public void receba (Comunicado x) throws Exception
    {
        try
        {
            this.transmissor.writeObject (x);
            this.transmissor.flush ();
        }
        catch (IOException erro)
        {
            throw new Exception ("Erro de transmissao");
        }
    }

    //ver oq foi mandado sem consumilo
    public Comunicado espie () throws Exception
    {
        try
        {
            this.mutEx.acquireUninterruptibly();//requisita recurso do semaforo
            if (this.proximoComunicado==null) this.proximoComunicado = (Comunicado)this.receptor.readObject();
            this.mutEx.release();
            return this.proximoComunicado;
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de recepcao");
        }
    }

    //recebe do cliente -> ex cliente.envie (isso no cliente)
    public Comunicado envie () throws Exception
    {
        try
        {
            if (this.proximoComunicado==null) this.proximoComunicado = (Comunicado)this.receptor.readObject();
            Comunicado aux = this.proximoComunicado;
            this.proximoComunicado = null;//pois ja recebeu, ent tem que consumir
            return aux;
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de recepcao");
        }
    }

    //desc servidor
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
