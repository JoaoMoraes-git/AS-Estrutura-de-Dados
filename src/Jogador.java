public class Jogador {
    private String nome;
    private double saldo;
    private Tabuleiro posAtual; //??
    private Tabuleiro posAnt; //??
    //Lista de propriedades aqui
    private Tipo profissao;

    public Jogador(String nome, double saldo, Tabuleiro posAtual, Tabuleiro posAnt, Tipo profissao) {
        this.nome = nome;
        this.saldo = saldo;
        this.posAtual = posAtual;
        this.posAnt = posAnt;
        this.profissao = profissao;
    }

    public Jogador(String nome, Tipo profissao, double saldo) {
        this.nome = nome;
        this.profissao = profissao;
        this.saldo = saldo;
    }
}
