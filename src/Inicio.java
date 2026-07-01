public class Inicio implements TipoCasa{
    double salario;

    public Inicio(double salario) {
        this.salario = salario;
    }

    @Override
    public void acao(Jogador jogador) {
        double salarioRecebido = this.salario * jogador.getProfissao().getMultSalario();
        System.out.println(jogador.getNome() + " voltou ao início e recebeu o seu salário de R$" + String.format("%.2f", salarioRecebido));
        jogador.saldo += salarioRecebido;

        jogador.adicionarVolta();
    }

    @Override
    public String toString() {
        return "Inicio";
    }
}
