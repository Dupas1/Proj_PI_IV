package Cliente;

public class PedidoDeOperacao extends Comunicado
{
    private char   operacao;
    private double valor;
    
    public PedidoDeOperacao (char operacao, double valor)
    {
        this.operacao = operacao;
        this.valor    = valor;
    }
    
    public String toString ()
    {
        return (""+this.operacao+this.valor);
    }
}
