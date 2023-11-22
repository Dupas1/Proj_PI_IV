package Cliente;

import java.net.*;
import java.io.*;

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

        int option=0;
        do
		{
            System.out.print ("Sua opção (1:Facíl , 2:Médio , 3:Difícil , 4:Encerra o servidor)? ");

            try
            {
				option = Teclado.getUmInt();
			}
		    catch (Exception erro)
		    {
				if (option > 4 || option<1){
					System.err.println ("Opcao invalida!\n");
					continue;
				}
			}

			try {
				if (option <= 3 || option >= 1) {
					if (option == 1) {

						try//inplementaçao da data
						{
							System.out.println(1);

						} catch (Exception erro) {
							System.err.println("Valor invalido!\n");
							continue;
						}

						servidor.receba(new PedidoDeEscolha(option));
					} else if (option == 2) {

						try//inplementaçao da data
						{
							System.out.println(2);

						} catch (Exception erro) {
							System.err.println("Valor invalido!\n");
							continue;
						}

						servidor.receba(new PedidoDeEscolha(option));
					} else if (option == 3) {

						try//inplementaçao da data
						{
							System.out.println(3);

						} catch (Exception erro) {
							System.err.println("Valor invalido!\n");
							continue;
						}

						servidor.receba(new PedidoDeEscolha(option));
					}
				}

				/*
				else if (option=='=')
				{
					servidor.receba (new PedidoDeResultado ());
					Comunicado comunicado = null;
					do
					{
						comunicado = (Comunicado)servidor.espie ();
					}
					while (!(comunicado instanceof Resultado));
					Resultado resultado = (Resultado)servidor.envie ();
					System.out.println ("Resultado atual: "+resultado.getValorResultante()+"\n");
				}*/
			}
			catch (Exception erro)
			{
				System.err.println ("Erro de comunicacao com o servidor;");
				System.err.println ("Tente novamente!");
				System.err.println ("Caso o erro persista, termine o programa");
				System.err.println ("e volte a tentar mais tarde!\n");
			}

        }while (option != '4'); //pensar na logistica de encerrar o servidor

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
