void main() {

    Scanner input = new Scanner(System.in);
    int escolha = 0;

    Profissao profissao = new Profissao(); //Fazer o sistema de profissão

    Tabuleiro tabuleiro = new Tabuleiro<>();
    Jogo jogo = new Jogo();

    Jogador j1 = new Jogador("Player 1", profissao, 2500.00);
    Jogador j2 = new Jogador("Player 2", profissao, 2500.00);
    Jogador j3 = new Jogador("Player 3", profissao, 2500.00);

    jogo.jogadores.add(j1);
    jogo.jogadores.add(j2);
    jogo.jogadores.add(j3);
    System.out.println(jogo.jogadores.get(0));

    Inicio casaInicio = new Inicio(100000.00);
    tabuleiro.inserirNoFim(casaInicio);

    // Adicionar jogador ao arraylist de jogo aqui

    tabuleiro.inserirNoFim(new Imovel("Casa de teste", 100.00, 10.00, 1.0));

    /*
    tabuleiro.inserirNoFim(new Imovel("Chalé da Serra Gaúcha", 200000.00, 1000.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Flat Paulista", 350000.00, 1750.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Sobrado de Ouro Preto", 400000.00, 2000.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Pousada do Pantanal", 500000.00, 2500.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Mansão de Gramado", 600000.00, 3000.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Cobertura de Florianópolis", 750000.00, 3750.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Fazenda do Cerrado", 280000.00, 1400.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Bangalô de Búzios", 450000.00, 2250.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Penthouse de Salvador", 850000.00, 4250.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Casa de Bonito", 220000.00, 1100.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Palacete de Petrópolis", 1000000.00, 5000.00, 1.0));
     */

    int qtdJogadores = jogo.jogadores.size();
    int ordemAtual = 0;

    // Configuração pré-jogo
    while (true) {
        System.out.println("Configurações iniciais");
        for (int i = 0; i < qtdJogadores; i++) {
            jogo.jogadores.get(i).setPosAtual(tabuleiro.getPosAtual());
        }
        break;
    }

    // Partida em andamento
    int turnosRestantes = 10;
    while (turnosRestantes > 0) {
        Jogador jogadorAtual = jogo.jogadores.get(ordemAtual);

        System.out.println("--Turnos restantes: " + turnosRestantes);
        System.out.println("|" + jogadorAtual.getNome() + "|" + jogadorAtual.getPosAtual().elemento);
        //tabuleiro.imprimir();

        // System.out.println("1 - Andar casas");
        escolha = input.nextInt();

        switch (escolha) {
            case 1:
                int valorRoll = tabuleiro.moverJogador(jogadorAtual, true);
                System.out.println(jogadorAtual.getNome() + " Andou " + valorRoll + " casas!");

                TipoCasa parouEm = (TipoCasa) jogadorAtual.getPosAtual().elemento;

                if(!(parouEm instanceof Inicio)){
                    parouEm.acao(jogadorAtual);
                }
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }

        ordemAtual++;

        if (ordemAtual == qtdJogadores) {
            System.out.println("Fim do turno");
            turnosRestantes--;
            ordemAtual = 0;
        }

    }

    System.out.println("Fim De Jogo");
    // Colocar rank final
}
