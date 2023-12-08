package com.woodpecker.backend.service;

import com.google.gson.Gson;
import com.woodpecker.backend.dtos.ShutdownOrder;
import com.woodpecker.backend.model.Partner;


public class HandlerShutDown extends Thread{
    private Partner servidor;

    public HandlerShutDown (Partner servidor) throws Exception
    {
        if (servidor==null)
            throw new Exception ("Porta invalida");

        this.servidor = servidor;
    }

    public void run ()
    {
        Gson gson = new Gson();
        for(;;)
        {
            try
            {
                Object order = gson.fromJson(this.servidor.espie(),Object.class);
                if (order.getClass().getSimpleName().equals("ShutdownOrder"))
                {
                    System.out.println ("\nO servidor vai ser desligado agora;");
                    System.err.println ("volte mais tarde!\n");
                    System.exit(0);
                }
            }
            catch (Exception erro)
            {}
        }
    }
}
