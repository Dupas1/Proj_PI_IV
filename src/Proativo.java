import java.io.*;
import java.net.*;

public class Proativo {
    public static void main (String[] args) throws IOException {
        try{
            Socket conexao = new Socket("localhost",12345);

            //ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream()); //fone, porem neste programa ele não é necessario

            ObjectOutputStream transmissor = new ObjectOutputStream(conexao.getOutputStream());//microfone

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));//

            String texto;

            do {
                texto = teclado.readLine();
                transmissor.writeObject(texto);
                transmissor.flush();//para enviar imediato
            }while(!texto.toUpperCase().equals("FIM"));//mandei "fim" acabou

            transmissor.close();
            //receptor.close();
            conexao.close();
        }
        catch (Exception erro)
        {
            System.err.println(erro.getMessage());
        }
    }
}

