public class Imposto implements TipoCasa {

    @Override
    public void acao(Jogador jogador) {
        double valorImoveis = 0;
        for (Imovel imovel : jogador.getPropriedades()) {
            valorImoveis += imovel.getPreco();
        }
        double patrimonioTotal = jogador.getSaldo() + valorImoveis;
        double valorImposto = patrimonioTotal * 0.05;
        double impostoCobrado = valorImposto * jogador.getProfissao().getMultiImposto();

        jogador.removerSaldo(impostoCobrado);

        System.out.println(jogador.getNome() + " caiu na casa de impostos e pagou R$" + String.format("%.2f", impostoCobrado));
    }

    @Override
    public String toString() {
        return "Imposto";
    }
}
