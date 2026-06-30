public class CartaEfeito implements TipoCasa{
    private PilhaCarta baralho;
    private Tabuleiro tabuleiro;
    private Jogo jogo;

    public CartaEfeito(PilhaCarta baralho, Tabuleiro tabuleiro, Jogo jogo) {
        this.baralho = baralho;
        this.tabuleiro = tabuleiro;
        this.jogo = jogo;
    }

    @Override
    public void acao(Jogador jogador) {
        System.out.println("#Casa de sorte ou azar");

        Carta cartePega = baralho.pegarCarta();
        System.out.println(jogador.getNome() + " pegou a carta: " + cartePega.getDescricao());

        switch (cartePega.getTipo()){

            case 1:
                jogador.saldo += cartePega.getValor();
                break;

            case 2:
                jogador.saldo -= cartePega.getValor();
                break;

            case 3:
                tabuleiro.moverJogador(jogador, cartePega.getValor(), true);

                TipoCasa novaCasa = (TipoCasa) jogador.getPosAtual().elemento;
                if (!(novaCasa instanceof Inicio)) novaCasa.acao(jogador);
                break;

            case 4:
                tabuleiro.moverJogador(jogador, cartePega.getValor(), false);

                TipoCasa casaRetorno = (TipoCasa) jogador.getPosAtual().elemento;
                if (!(casaRetorno instanceof Inicio)) casaRetorno.acao(jogador);
                break;

            case 5:
                System.out.println("Pegou o voo direto para o início");

                jogador.setPosAtual(tabuleiro.getPosAtual());
                TipoCasa casaInicio = (TipoCasa) jogador.getPosAtual().elemento;
                casaInicio.acao(jogador);
                break;

            case 7:
                double valorPagar = cartePega.getValor();
                for (Jogador outro : jogo.jogadores) {
                    if (outro != jogador) {
                        jogador.saldo -= valorPagar;
                        outro.saldo += valorPagar;
                    }
                }
                break;

            case 8:
                double valorReceber = cartePega.getValor();
                for (Jogador outro : jogo.jogadores){
                    if (outro != jogador) {
                        outro.saldo -= valorReceber;
                        jogador.saldo += valorReceber;
                    }
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "Sorte ou Azar";
    }
}
