public class Restituicao implements TipoCasa {

    @Override
    public void acao(Jogador jogador) {
        double valorGanho = jogador.saldo * 0.10;
        jogador.saldo += valorGanho;

        System.out.println(jogador.getNome() + " caiu na casa de Restituição e recebeu um valor de " + valorGanho + " do banco");
    }

    @Override
    public String toString() {
        return "Restituicao";
    }
}
