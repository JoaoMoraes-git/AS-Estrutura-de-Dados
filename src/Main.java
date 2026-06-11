void main() {

    Scanner input = new Scanner(System.in);
    int escolha = 0;

    Tipo profissao = new Tipo();
    Tabuleiro tabuleiro = new Tabuleiro<>();
    Jogador j = new Jogador("Player 1", profissao, 2500.00);

    tabuleiro.inserirNoFim("Campo 1");
    tabuleiro.inserirNoFim("Campo 2");
    tabuleiro.inserirNoFim("Campo 3");
    tabuleiro.inserirNoFim("Campo 4");
    tabuleiro.inserirNoFim("Campo 5");
    tabuleiro.inserirNoFim("Campo 6");
    tabuleiro.inserirNoFim("Campo 7");
    tabuleiro.inserirNoFim("Campo 8");
    tabuleiro.inserirNoFim("Campo 9");
    tabuleiro.inserirNoFim("Campo 10");
    tabuleiro.inserirNoFim("Campo 11");
    tabuleiro.inserirNoFim("Campo 12");

    //Configuração pré-jogo
    while (true) {
        System.out.println("Configurações iniciais");
        break;
    }

    //Partida em andamento
    int turnosRestantes = 3;
    while (turnosRestantes > 0) {
        escolha = input.nextInt();
        if (escolha == 1){
            tabuleiro.imprimir();
        } else if (escolha == 2){
            System.out.println(tabuleiro.rolagem());
        } else if (escolha == 3){
            tabuleiro.avancar();
        }

        turnosRestantes--;
        
    }

    System.out.println("Fim De Jogo");
    //Colocar rank final
}
