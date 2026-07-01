import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    public double saldo;
    private Casa posAtual;
    private List<Imovel> propriedades;
    private Profissao profissao;

    private int voltasCompletas = 0;

    public Jogador(String nome, double saldo, Casa posAtual, Profissao profissao) {
        this.nome = nome;
        this.saldo = saldo;
        this.posAtual = posAtual;
        this.profissao = profissao;

        this.propriedades = new ArrayList<>();
    }

    public Jogador(String nome, Profissao profissao, double saldo) {
        this.nome = nome;
        this.profissao = profissao;
        this.saldo = saldo;

        this.propriedades = new ArrayList<>();
    }

    public int getVoltasCompletas() {
        return voltasCompletas;
    }

    public void adicionarVolta() {
        this.voltasCompletas++;
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

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "Turno de: " + nome + " | Saldo: " + saldo;
    }

}
