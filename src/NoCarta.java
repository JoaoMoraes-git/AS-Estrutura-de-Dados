public class NoCarta {
    public Carta carta;
    public NoCarta proximo;

    public NoCarta(Carta carta){
        this.carta = carta;
        this.proximo = null;
    }
}
