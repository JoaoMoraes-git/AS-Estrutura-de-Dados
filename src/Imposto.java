public class Imposto implements TipoCasa {

    @Override
    public void acao(Jogador jogador) {
        double valorImposto = jogador.saldo * 0.05;

        jogador.saldo -= valorImposto;

        System.out.println(jogador.getNome() + " caiu na casa de impostos e pagou " + valorImposto);
    }

    @Override
    public String toString() {
        return "Imposto";
    }
}
