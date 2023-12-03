package Cliente;

import Cliente.PedidoDeCalculoDeRevisao;
import Cliente.Teclado;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente
{
	public static final String HOST  = "localhost";
	public static final int PORTA = 3000;

	public static void main (String[] args)
	{
        if (args.length>2) //terminal receber mais de dois args
        {
            System.err.println ("Uso esperado: java Cliente [HOST [PORTA]]\n");
            return;
        }

        Socket conexao=null;
        try
        {
            String host = Cliente.HOST;
            int    porta= Cliente.PORTA;

            if (args.length>0)
                host = args[0];// primeira coisa do args no terminal q serial o "localhost"

            if (args.length==2)
                porta = Integer.parseInt(args[1]);//segunda coisa do terminal q seria a porta

            conexao = new Socket (host, porta);
        }
        catch (Exception erro)
        {
            System.err.println ("Indique o servidor e a porta corretos!\n");
            return;
        }

        ObjectOutputStream transmissor=null;
        try
        {
            transmissor =
            new ObjectOutputStream(
            conexao.getOutputStream());
        }
        catch (Exception erro)
        {
            System.err.println ("Indique o servidor e a porta corretos!\n");
            return;
        }

        ObjectInputStream receptor=null;
        try
        {
            receptor =
            new ObjectInputStream(
            conexao.getInputStream());
        }
        catch (Exception erro)
        {
            System.err.println ("Indique o servidor e a porta corretos!\n");
            return;
        }

        Parceiro servidor=null;
        try
        {
            servidor =
            new Parceiro (conexao, receptor, transmissor);
        }
        catch (Exception erro)
        {
            System.err.println ("Indique o servidor e a porta corretas!\n");
            return;
        }

        TratadoraDeComunicadoDeDesligamento tratadoraDeComunicadoDeDesligamento = null;
        try
        {
			tratadoraDeComunicadoDeDesligamento = new TratadoraDeComunicadoDeDesligamento (servidor);
		}
		catch (Exception erro)
		{} // sei que servidor foi instanciado
		
        tratadoraDeComunicadoDeDesligamento.start();

        String opt="";
        int numberReview=0;
        do
		{
            opt="";
            System.out.print ("Sua opção (1:BEGIN , 2:EASY , 3:MEDIUM ,4:HARD, 5:Encerra o servidor)? ");

            try {
                  opt = Teclado.getUmString().toUpperCase();

                System.out.println();
                servidor.receba(new PedidoDeCalculoDeRevisao(numberReview,opt));

            }
			catch (Exception erro)
			{
				System.err.println ("Erro de comunicacao com o servidor;");
				System.err.println ("Tente novamente!");
				System.err.println ("Caso o erro persista, termine o programa");
				System.err.println ("e volte a tentar mais tarde!\n");
			}

        }while (opt != "5"); //pensar na logistica de encerrar o servidor

		try
		{
			servidor.receba (new PedidoParaSair ());
		}
		catch (Exception erro)
		{}
		
		System.out.println ("Obrigado por usar este programa!");
		System.exit(0);
	}
}
