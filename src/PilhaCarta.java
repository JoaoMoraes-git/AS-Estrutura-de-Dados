public class PilhaCarta {
    private NoCarta topo;

    public PilhaCarta(){
        this.topo = null;
    }

    public void empilhar(Carta carta) {
        NoCarta novoNo = new NoCarta(carta);
        if (this.topo != null){
            novoNo.proximo = this.topo;
        }
        this.topo = novoNo;
    }

    public void gerarBaralho(){
        Carta[] deck = new Carta[12];

        deck[0] = new Carta("[SORTE]: Erro do banco a seu favor! Receba R$ 500.", 1, 500);
        deck[1] = new Carta("[SORTE]: Herança inesperada! Receba R$ 1000.", 1, 1000);
        deck[2] = new Carta("[SORTE]: Trânsito bom! Avance 3 casas.", 3, 3);
        deck[3] = new Carta("[SORTE]: Pegou uma carona! Avance 5 casas.", 3, 5);
        deck[4] = new Carta("[SORTE]: Viagem de avião! Vá diretamente para o [Início].", 5, 0);
        deck[5] = new Carta("[SORTE]: Hoje é seu aniversário! Todos os jogadores te pagam R$ 100.", 8, 100);

        deck[6] = new Carta("[AZAR]: Multa de trânsito! Pague R$ 200.", 2, 200);
        deck[7] = new Carta("[AZAR]: Bateu o carro! Pague R$ 400.", 2, 400);
        deck[8] = new Carta("[AZAR]: Pneu furado! Volte 2 casas.", 4, 2);
        deck[9] = new Carta("[AZAR]: Trânsito intenso! Volte 4 casas.", 4, 4);
        deck[10] = new Carta("[AZAR]: Chuva forte destelhou sua casa! Pague R$ 300 para o conserto.", 2, 300);
        deck[11] = new Carta("[AZAR]: Processo coletivo! Pague R$ 150 a todos os outros jogadores.", 7, 150);

        for (int i = deck.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));

            Carta temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }

        for (int i = 0; i < deck.length; i++) {
            this.empilhar(deck[i]);
        }
    }


    public Carta pegarCarta(){
        if (this.topo == null){
            System.out.println("O baralho está vazio, e será reembaralhado");
            gerarBaralho();
        }

        Carta cartaPega = this.topo.carta;
        this.topo = this.topo.proximo;
        return cartaPega;
    }

}
