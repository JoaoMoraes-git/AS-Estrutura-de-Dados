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

        Carta cartaPega = baralho.pegarCarta();
        System.out.println(jogador.getNome() + " pegou a carta: " + cartaPega.getDescricao());

        switch (cartaPega.getTipo()){

            case 1:
                jogador.adicionarSaldo(cartaPega.getValor());
                break;

            case 2:
                jogador.removerSaldo(cartaPega.getValor());
                break;

            case 3:
                tabuleiro.moverJogador(jogador, cartaPega.getValor(), true);

                TipoCasa novaCasa = (TipoCasa) jogador.getPosAtual().elemento;
                if (!(novaCasa instanceof Inicio)) novaCasa.acao(jogador);
                break;

            case 4:
                tabuleiro.moverJogador(jogador, cartaPega.getValor(), false);

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
                double valorPagar = cartaPega.getValor();
                for (Jogador outro : jogo.jogadores) {
                    if (outro != jogador) {
                        jogador.removerSaldo(valorPagar);
                        outro.adicionarSaldo(valorPagar);
                    }
                }
                break;

            case 8:
                double valorReceber = cartaPega.getValor();
                for (Jogador outro : jogo.jogadores){
                    if (outro != jogador) {
                        outro.removerSaldo(valorReceber);
                        jogador.adicionarSaldo(valorReceber);
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
