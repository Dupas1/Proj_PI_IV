package Servidor;

public class PedidoDeEscolha extends Comunicado{

    private int option;
    private String dificuldade;

    //inplementar construtor com o codigo
    public PedidoDeEscolha(int option){
        this.option = option;

        if (option==1){
            this.dificuldade="facil";
        }
        if (option==2){
            this.dificuldade="médio";
        }
        if (option==3){
            this.dificuldade="Difícil";
        }
    }

    public int getOption() {
        return option;
    }


    public String getDificuldade() {
        return dificuldade;
    }


    @Override
    public String toString ()
    {
        return (""+this.option+": "+this.dificuldade);
    }

}
