import java.util.Random;

public class Tabuleiro<T> {
    private No<T> fim;
    private No<T> casaAtual;
    private int tamanho;

    Random dado = new Random();

    public Tabuleiro() {
        this.fim = null;
    }

    public void inserirNoFim(T valor) {
        No<T> novo = new No<>(valor);
        if (fim == null) {
            fim = novo;
            fim.proximo = fim;
        } else {
            novo.proximo = fim.proximo;
            fim.proximo = novo;
            fim = novo;
        }
    }

    public void avancar(){

        int valorRoll = rolagem();

        for (int i = valorRoll; i > 0; i--){ //A primeira rolagem está errada, andando uma casa a menos, como se começasse em um campo 0 ao invés de 1
            if (casaAtual == null){
                casaAtual = fim.proximo;
            } else {
                casaAtual = casaAtual.proximo;
            }
        }

        System.out.println(casaAtual.dado);
        System.out.println("Você andou " + valorRoll + " casas");
    }

    public int rolagem() {
        int valorRoll = dado.nextInt(1, 7) + dado.nextInt(1, 7);
        return valorRoll;
    }

    public T removerNoInicio() {
        if (fim == null) return null;
        No<T> inicio = fim.proximo;
        T valor = inicio.dado;
        if (fim == inicio) {
            fim = null;
        } else {
            fim.proximo = inicio.proximo;
        }
        return valor;
    }

    public void imprimir() {
        if (fim == null) return;
        No<T> atual = fim.proximo;
        do {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        } while (atual != fim.proximo);
        System.out.println();
    }

    public void getPosAtual() {
        if (fim == null) return;


    }

}
