import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int escolha = 0;

        Configuracoes config = new Configuracoes();
        config.configurar();

        Tabuleiro tabuleiro = new Tabuleiro<>();
        Jogo jogo = new Jogo();

        jogo.jogadores.addAll(config.getJogadoresCadastrados());

        PilhaCarta baralho = new PilhaCarta();
        baralho.gerarBaralho();

        System.out.println(jogo.jogadores.get(0));

        Inicio casaInicio = new Inicio(config.getSalarioBase());
        tabuleiro.inserirNoFim(casaInicio);

        ArrayList<Imovel> imoveis = config.getImoveisCadastrados();

        for (int i = 0; i < imoveis.size(); i++) {
            tabuleiro.inserirNoFim(imoveis.get(i));

            if (i == 1 || i == 4 || i == 7) {
                tabuleiro.inserirNoFim(new CartaEfeito(baralho, tabuleiro, jogo));
            } else if (i == 2) {
                tabuleiro.inserirNoFim(new Imposto());
            } else if (i == 3) {
                tabuleiro.inserirNoFim(new Restituicao());
            }
        }

        int qtdJogadores = jogo.jogadores.size();
        int ordemAtual = 0;

        while (true) {
            System.out.println("Configurações iniciais");
            for (int i = 0; i < qtdJogadores; i++) {
                jogo.jogadores.get(i).setPosAtual(tabuleiro.getPosAtual());
            }
            break;
        }

        int turnosRestantes = config.getTurnos();

        while (turnosRestantes > 0) {
            Jogador jogadorAtual = jogo.jogadores.get(ordemAtual);

            System.out.println("--Turnos restantes: " + turnosRestantes);
            System.out.println("|" + jogadorAtual.getNome() + "|" + jogadorAtual.getPosAtual().elemento);

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
    }
}