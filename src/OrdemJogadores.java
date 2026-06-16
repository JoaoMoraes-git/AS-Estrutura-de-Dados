public class OrdemJogadores<T> {
    private No<T> fim;
    private No<T> jogadorAtual;

    public OrdemJogadores() {
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

    //Remover no fim aqui

    public void passarTurno(){
        jogadorAtual = jogadorAtual.proximo;
    }

    public No<T> getFim() {
        return fim;
    }

    public void setFim(No<T> fim) {
        this.fim = fim;
    }

    public No<T> getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(No<T> jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }
}
