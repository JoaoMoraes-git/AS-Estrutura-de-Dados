void main() {

    Scanner input = new Scanner(System.in);
    int escolha = 0;

    Tipo profissao = new Tipo();
    Tabuleiro tabuleiro = new Tabuleiro<>();
    Jogo jogo = new Jogo();

    Jogador j1 = new Jogador("Player 1", profissao, 2500.00);
    Jogador j2 = new Jogador("Player 2", profissao, 2500.00);
    Jogador j3 = new Jogador("Player 3", profissao, 2500.00);

    jogo.jogadores.add(j1);
    jogo.jogadores.add(j2);
    jogo.jogadores.add(j3);
    System.out.println(jogo.jogadores.get(0));

    //Adicionar jogador ao arraylist de jogo aqui

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

    int qtdJogadores = jogo.jogadores.size() - 1;
    int ordemAtual = 0;

    //Configuração pré-jogo
    while (true) {
        System.out.println("Configurações iniciais");
        for (int i = 0; i <= qtdJogadores; i++){
            jogo.jogadores.get(i).setPosAtual(tabuleiro.getPosAtual());
        }
        break;
    }




    //Partida em andamento
    int turnosRestantes = 3;
    while (turnosRestantes > 0) {
        Jogador jogadorAtual = jogo.jogadores.get(ordemAtual);

        tabuleiro.imprimir();

        System.out.println("|" + jogadorAtual.getNome() + "|");
        System.out.println("1 - Andar casas");
        System.out.println("Turnos restantes: " + turnosRestantes);
        escolha = input.nextInt();

        switch (escolha){
            case 1:
                int valorRoll = tabuleiro.rolagem();
                System.out.println(jogadorAtual.getNome() + " Andou " + valorRoll + " casas!");
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }


        if (ordemAtual == qtdJogadores){
            System.out.println("Fim do turno");
            turnosRestantes--;
            ordemAtual = 0;
        } else {
            ordemAtual++;
        }

        
    }

    System.out.println("Fim De Jogo");
    //Colocar rank final
}
