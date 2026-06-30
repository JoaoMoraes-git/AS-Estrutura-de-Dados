void main() {

    Scanner input = new Scanner(System.in);
    int escolha = 0;

    Profissao profissao = new Profissao(); //Fazer o sistema de profissão

    Tabuleiro tabuleiro = new Tabuleiro<>();
    Jogo jogo = new Jogo();

    // 1. Instanciando e gerando o baralho ANTES de criar as casas
    PilhaCarta baralho = new PilhaCarta();
    baralho.gerarBaralho();

    Profissao profEspeculador = new Profissao("Especulador", 1.2, 1.1, 1.0, 1.0);
    Profissao profNegociante = new Profissao("Negociante", 1.0, 1.0, 0.9, 1.0);
    Profissao profAdvogado = new Profissao("Advogado", 1.0, 0.0, 1.0, 1.0);
    Profissao profConstrutor = new Profissao("Construtor", 1.0, 1.0, 1.0, 1.15);

    Jogador j1 = new Jogador("Player 1", profissao, 2500.00);
    Jogador j2 = new Jogador("Player 2", profissao, 2500.00);
    Jogador j3 = new Jogador("Player 3", profissao, 2500.00);
    Jogador j4 = new Jogador("Player 4", profissao, 2500.00);

    jogo.jogadores.add(j1);
    jogo.jogadores.add(j2);
    jogo.jogadores.add(j3);
    System.out.println(jogo.jogadores.get(0));

    // Salário balanceado para R$ 1.000,00
    Inicio casaInicio = new Inicio(1000.00);
    tabuleiro.inserirNoFim(casaInicio);

    // 2. Inserindo os imóveis (preços e aluguéis balanceados) e intercalando as NOVAS casas
    tabuleiro.inserirNoFim(new Imovel("Chalé da Serra Gaúcha", 400.00, 50.00, 1.0));
    tabuleiro.inserirNoFim(new CartaEfeito(baralho, tabuleiro, jogo)); // <--- CASA DO BARALHO (Sorte/Azar)

    tabuleiro.inserirNoFim(new Imovel("Flat Paulista", 600.00, 80.00, 1.0));
    tabuleiro.inserirNoFim(new Imposto()); // <--- NOVA: Imposto

    tabuleiro.inserirNoFim(new Imovel("Sobrado de Ouro Preto", 800.00, 100.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Pousada do Pantanal", 1000.00, 150.00, 1.0));
    tabuleiro.inserirNoFim(new Restituicao()); // <--- NOVA: Restituição

    tabuleiro.inserirNoFim(new Imovel("Fazenda do Cerrado", 1200.00, 180.00, 1.0));
    tabuleiro.inserirNoFim(new CartaEfeito(baralho, tabuleiro, jogo)); // <--- CASA DO BARALHO (Sorte/Azar)

    tabuleiro.inserirNoFim(new Imovel("Bangalô de Búzios", 1500.00, 250.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Casa de Bonito", 1800.00, 300.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Mansão de Gramado", 2200.00, 400.00, 1.0));
    tabuleiro.inserirNoFim(new CartaEfeito(baralho, tabuleiro, jogo)); // <--- CASA DO BARALHO (Sorte/Azar)

    tabuleiro.inserirNoFim(new Imovel("Cobertura de Florianópolis", 2600.00, 500.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Penthouse de Salvador", 3000.00, 600.00, 1.0));
    tabuleiro.inserirNoFim(new Imovel("Palacete de Petrópolis", 3500.00, 800.00, 1.0));

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