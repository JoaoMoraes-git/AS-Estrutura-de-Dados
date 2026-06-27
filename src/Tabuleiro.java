import java.util.Random;

public class Tabuleiro<T> {
    private Casa<T> fim;
    private Casa<T> casaAtual;
    private int tamanho;

    Random dado = new Random();

    public Tabuleiro() {
        this.fim = null;
    }

    public void inserirNoFim(T valor) {
        Casa<T> CasaNova = new Casa<>(valor);
        if (fim == null) {
            fim = CasaNova;
            fim.proximo = fim;
        } else {
            CasaNova.proximo = fim.proximo;
            fim.proximo = CasaNova;
            fim = CasaNova;
        }
    }

    public void avancar(){

        int valorRoll = rolagem();

        for (int i = valorRoll; i > 0; i--){ //A primeira rolagem está errada, andando uma casa a meCasas, como se começasse em um campo 0 ao invés de 1
            if (casaAtual == null){
                casaAtual = fim.proximo;
            } else {
                casaAtual = casaAtual.proximo;
            }
        }

        System.out.println(casaAtual.elemento);
        System.out.println("Você andou " + valorRoll + " casas");
    }

    public int rolagem() {
        int valorRoll = dado.nextInt(1, 7) + dado.nextInt(1, 7);
        return valorRoll;
    }

    public T removerNoInicio() {
        if (fim == null) return null;
        Casa<T> inicio = fim.proximo;
        T valor = inicio.elemento;
        if (fim == inicio) {
            fim = null;
        } else {
            fim.proximo = inicio.proximo;
        }
        return valor;
    }

    public void imprimir() {
        if (fim == null) return;
        Casa<T> atual = fim.proximo;
        do {
            System.out.print(atual.elemento + " ");
            atual = atual.proximo;
        } while (atual != fim.proximo);
        System.out.println();
    }

    public Casa getPosAtual() {
        if (fim == null) return null;


        return null;
    }

}
