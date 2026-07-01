import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Preparando o essencial
        Scanner input = new Scanner(System.in);

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

        //Geração de tabuleiro
        for (int i = 0; i < imoveis.size(); i++) {
            tabuleiro.inserirNoFim(imoveis.get(i));

            if (i == 1 || i == 4 || i == 7) {
                tabuleiro.inserirNoFim(new CartaEfeito(baralho, tabuleiro, jogo));
            } else if (i == 2) {
                tabuleiro.inserirNoFim(new Imposto());
            } else if (i == 3) {
                tabuleiro.inserirNoFim(new Restituicao(config.getSalarioBase()));
            }
        }

        //Configurações pré-partida
        int qtdJogadores = jogo.jogadores.size();
        int ordemAtual = 0;

        while (true) {
            System.out.println("Configurações iniciais");
            for (int i = 0; i < qtdJogadores; i++) {
                jogo.jogadores.get(i).setPosAtual(tabuleiro.getPosAtual());
            }
            break;
        }

        //Menu de jogo
        int turnosRestantes = config.getTurnos();

        while (turnosRestantes > 0) {
            Jogador jogadorAtual = jogo.jogadores.get(ordemAtual);

            System.out.println("\n=============================================");
            System.out.println("-- Turnos restantes: " + turnosRestantes + " --");
            System.out.println(
                    "Vez de: " + jogadorAtual.getNome() + " | Profissão: " + jogadorAtual.getProfissao().getTitulo());
            System.out.println("Saldo Atual: R$ " + String.format("%.2f", jogadorAtual.saldo));
            System.out.println("Posição Atual: " + jogadorAtual.getPosAtual().elemento);

            System.out.print("Propriedades: ");
            boolean temPropriedade = false;
            for (Imovel imovel : imoveis) {
                if (imovel.getDono() != null && imovel.getDono().equals(jogadorAtual)) {
                    System.out.print("[" + imovel.getNome() + "] ");
                    temPropriedade = true;
                }
            }
            if (!temPropriedade) {
                System.out.print("Nenhuma");
            }
            System.out.println("\n=============================================");

            System.out.print("Digite qualquer tecla e pressione ENTER para rolar os dados: ");
            input.next();

            int valorRoll = tabuleiro.moverJogador(jogadorAtual, true);
            System.out.println(jogadorAtual.getNome() + " andou " + valorRoll + " casas!");

            TipoCasa parouEm = (TipoCasa) jogadorAtual.getPosAtual().elemento;

            if (!(parouEm instanceof Inicio)) {
                parouEm.acao(jogadorAtual);
            }

            if (jogadorAtual.saldo < 0) {
                System.out.println(
                        "!!! FALÊNCIA !!! O jogador " + jogadorAtual.getNome() + " faliu e está fora da partida!");

                for (Imovel imovel : imoveis) {
                    if (imovel.getDono() != null && imovel.getDono().equals(jogadorAtual)) {
                        imovel.setDono(null);
                    }
                }

                jogo.jogadores.remove(jogadorAtual);
                qtdJogadores--;
                ordemAtual--;
            }

            if (jogo.jogadores.size() == 1) {
                System.out.println("\nPartida encerrada antecipadamente! Restou apenas um jogador vivo.");
                break;
            }

            ordemAtual++;

            if (ordemAtual == qtdJogadores) {
                System.out.println("\n>>> Fim da rodada <<<");
                turnosRestantes--;
                ordemAtual = 0;
            }
        }

        //Relatório de fim de partida
        System.out.println("\n==================================");
        System.out.println("======= RELATÓRIO FINAL ========");
        System.out.println("==================================");

        Imovel imovelMaisCaro = null;
        double maiorAluguel = 0;

        for (Imovel imovel : imoveis) {
            double aluguelAtual = imovel.getAluguelBase() * imovel.getMultiplicador();
            if (aluguelAtual > maiorAluguel) {
                maiorAluguel = aluguelAtual;
                imovelMaisCaro = imovel;
            }
        }

        if (imovelMaisCaro != null) {
            System.out.println("\n[MERCADO IMOBILIÁRIO]");
            System.out.println("Imóvel mais valorizado: " + imovelMaisCaro.getNome());
            System.out.println("Aluguel final atingido: R$" + String.format("%.2f", maiorAluguel));
        }

        System.out.println("\n[CLASSIFICAÇÃO DOS JOGADORES]");
        System.out.println("----------------------------------");

        for (int i = 0; i < jogo.jogadores.size() - 1; i++) {
            for (int j = 0; j < jogo.jogadores.size() - 1 - i; j++) {
                double patrimonioA = jogo.jogadores.get(j).saldo + calcularValorImoveis(jogo.jogadores.get(j), imoveis);
                double patrimonioB = jogo.jogadores.get(j + 1).saldo
                        + calcularValorImoveis(jogo.jogadores.get(j + 1), imoveis);

                if (patrimonioA < patrimonioB) {
                    Jogador temp = jogo.jogadores.get(j);
                    jogo.jogadores.set(j, jogo.jogadores.get(j + 1));
                    jogo.jogadores.set(j + 1, temp);
                }
            }
        }

        for (int i = 0; i < jogo.jogadores.size(); i++) {
            Jogador j = jogo.jogadores.get(i);
            double patrimonioTotal = j.saldo + calcularValorImoveis(j, imoveis);

            System.out.println((i + 1) + "º Lugar: " + j.getNome() + " (" + j.getProfissao().getTitulo() + ")");
            System.out.println("   Patrimônio Total: R$" + String.format("%.2f", patrimonioTotal) + " (Saldo: R$"
                    + String.format("%.2f", j.saldo) + ")");
            System.out.println("   Voltas completadas: " + j.getVoltasCompletas());
            System.out.println("----------------------------------");
        }
    }

    private static double calcularValorImoveis(Jogador jogador, ArrayList<Imovel> todosImoveis) {
        double valorTotal = 0;
        for (Imovel imovel : todosImoveis) {
            if (imovel.getDono() != null && imovel.getDono().equals(jogador)) {
                valorTotal += imovel.getPreco();
            }
        }
        return valorTotal;
    }
}