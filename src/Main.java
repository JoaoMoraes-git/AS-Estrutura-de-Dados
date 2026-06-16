void main() {

    Scanner input = new Scanner(System.in);
    int escolha = 0;

    Tipo profissao = new Tipo();
    Tabuleiro tabuleiro = new Tabuleiro<>();
    OrdemJogadores ordem = new OrdemJogadores<>();
    Jogador j1 = new Jogador("Player 1", profissao, 2500.00);
    Jogador j2 = new Jogador("Player 2", profissao, 2500.00);

    ordem.inserirNoFim(j1);
    ordem.inserirNoFim(j2);

    tabuleiro.inserirNoFim("[Início]");
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
        tabuleiro.imprimir();

        System.out.println("1 - Andar casas");
        escolha = input.nextInt();

        switch (escolha){
            case 1:
                int valorRoll = tabuleiro.rolagem();
                System.out.println("[Nome aqui]" + " Andou " + valorRoll + " casas!");


                break;

            default:
                System.out.println("Opção inválida");
                break;
        }


        turnosRestantes--;
        
    }

    System.out.println("Fim De Jogo");
    //Colocar rank final
}
