import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private double saldo;
    private Casa posAtual;
    private List<Imovel> propriedades;
    private Tipo profissao;

    public Jogador(String nome, double saldo, Casa posAtual, Tipo profissao) {
        this.nome = nome;
        this.saldo = saldo;
        this.posAtual = posAtual;
        this.profissao = profissao;
    }

    public Jogador(String nome, Tipo profissao, double saldo) {
        this.nome = nome;
        this.profissao = profissao;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Casa getPosAtual() {
        return posAtual;
    }

    public void setPosAtual(Casa posAtual) {
        this.posAtual = posAtual;
    }

    public List<Imovel> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(List<Imovel> propriedades) {
        this.propriedades = propriedades;
    }

    public Tipo getProfissao() {
        return profissao;
    }

    public void setProfissao(Tipo profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "Turno de: " + nome + " | Saldo: " + saldo;
    }

}
