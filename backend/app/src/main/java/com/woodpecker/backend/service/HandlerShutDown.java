package com.woodpecker.backend.service;

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
        for(;;)
        {
            try
            {
                if (this.servidor.espie() instanceof ShutdownOrder)
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
