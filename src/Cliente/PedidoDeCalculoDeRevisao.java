package Cliente;

public class PedidoDeCalculoDeRevisao extends Comunicado{

    private int numberReview;
    private String difficulty;

    public PedidoDeCalculoDeRevisao(int numberReview, String dificulty) {
        this.numberReview = numberReview;
        this.difficulty = dificulty;
    }

    @Override
    public String toString() {
        return "PedidoDeCalculoDeRevisao{" +
                "numberReview=" + numberReview +
                ", dificulty='" + difficulty + '\'' +
                '}';
    }
}





