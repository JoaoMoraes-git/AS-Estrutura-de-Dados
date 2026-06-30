public class Inicio implements TipoCasa{
    double salario;

    public Inicio(double salario) {
        this.salario = salario;
    }

    @Override
    public void acao(Jogador jogador) {
        System.out.println(jogador.getNome() + " voltou ao início e recebeu o seu salário de R$" + this.salario);
        jogador.saldo += salario;
    }

    @Override
    public String toString() {
        return "Inicio";
    }
}
