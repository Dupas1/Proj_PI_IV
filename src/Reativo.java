import java.io.*;
import java.net.*;

public class Reativo {
    public static void main (String[] args){

        try
        {
            ServerSocket pedido = new ServerSocket(12345);

            //fio do telefone
            Socket conexao = pedido.accept();//1 ponta do fio

            ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream()); //fone

            //ObjectOutputStream transmissor = new ObjectOutputStream(conexao.getOutputStream());//microfone,porem neste programa ele não é necessario

            String texto;

            do {
                texto = (String)receptor.readObject();//pegou a informação do proativo// tenho que falar que é estring pelo receptior ser object
                System.out.println(texto);
            }while(!texto.toUpperCase().equals("FIM"));

            //transmissor.close();
            receptor.close();
            conexao.close();
            pedido.close();
        }
        catch (Exception erro)
        {
            System.err.println(erro.getMessage());
        }

    }
}
