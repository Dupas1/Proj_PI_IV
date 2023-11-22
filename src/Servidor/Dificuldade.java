package Servidor;

public class Dificuldade extends Comunicado
//servidor manda pro cliente
{
    private String dificuldade;

    public Dificuldade (String dificuldade)
    {
        this.dificuldade = dificuldade;
    }

    public String getDificuldade ()
    {
        return this.dificuldade;
    }

    public String toString ()
    {
        return (""+this.dificuldade);
    }

}