import java.util.Random;

public class Tabuleiro<T> {
    private Casa<T> inicio;
    private Casa<T> fim;
    private int tamanho;


    Random dado = new Random();

    public Tabuleiro() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void inserirNoFim(T valor) {
        Casa<T> CasaNova = new Casa<>(valor);
        if (inicio == null) {
            inicio = CasaNova;
            fim = CasaNova;
            inicio.proximo = inicio;
            inicio.anterior = inicio;
        } else {
            CasaNova.proximo = inicio;
            CasaNova.anterior = fim;
            fim.proximo = CasaNova;
            inicio.anterior = CasaNova;
            fim = CasaNova;
        }
        tamanho++;
    }

    public int moverJogador(Jogador j, boolean andandoFrente){
        int valorRoll = rolagem();
        Casa<T> posicao = j.getPosAtual();
        System.out.println(j.getNome() + " andou " + valorRoll + " casas");

        for (int i = 0; i < valorRoll; i++){
            if (andandoFrente) {
                posicao = posicao.proximo;

                if (posicao.elemento instanceof Inicio) {
                    ((Inicio) posicao.elemento).acao(j);
                }
            } else {
                posicao = posicao.anterior;
            }

        }

        j.setPosAtual(posicao);
        System.out.println(j.getNome() + " caiu na casa " + j.getPosAtual().elemento);

        return valorRoll;
    }

    public int moverJogador(Jogador j, int qtdCasas, boolean andandoFrente) {
        Casa<T> posicao = j.getPosAtual();
        System.out.println(j.getNome() + (andandoFrente ? " andou " : " voltou ") + qtdCasas + " casas");

        for (int i = 0; i < qtdCasas; i++) {
            if (andandoFrente) {
                posicao = posicao.proximo;

                // Dá o salário se passar pelo Início
                if (posicao.elemento instanceof Inicio) {
                    ((Inicio) posicao.elemento).acao(j);
                }
            } else {
                // Se for para trás, só recua sem checar salário
                posicao = posicao.anterior;
            }
        }

        j.setPosAtual(posicao);
        System.out.println(j.getNome() + " parou na casa " + j.getPosAtual().elemento);

        return qtdCasas;
    }


    public int rolagem() {
        int valorRoll = dado.nextInt(1, 7) + dado.nextInt(1, 7);
        return valorRoll;
    }

    public T removerNoInicio() {
        if (inicio == null) return null;
        T valor = inicio.elemento;
        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = fim;
            fim.proximo = inicio;
        }
        tamanho--;
        return valor;
    }

    public void imprimir() {
        if (inicio == null) return;
        Casa<T> atual = inicio;
        do {
            System.out.print(atual.elemento + " ");
            atual = atual.proximo;
        } while (atual != inicio);
        System.out.println();
    }

    public Casa<T> getPosAtual() {
        return inicio;
    }

}
