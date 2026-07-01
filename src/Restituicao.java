public class Restituicao implements TipoCasa {
    private double salarioBase;

    public Restituicao(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public void acao(Jogador jogador) {
        double valorGanho = this.salarioBase * 0.10;
        jogador.adicionarSaldo(valorGanho);

        System.out.println(jogador.getNome() + " caiu na casa de Restituição e recebeu um valor de R$" + String.format("%.2f", valorGanho) + " do banco");
    }

    @Override
    public String toString() {
        return "Restituicao";
    }
}
