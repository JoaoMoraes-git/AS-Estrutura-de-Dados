import java.util.Scanner;

public class Imovel implements TipoCasa{
    private String nome;
    private Double preco;
    private Double aluguelBase;
    private Jogador dono;
    private Double multiplicador;

    Scanner input = new Scanner(System.in);

    public Imovel(String nome, Double preco, Double aluguelBase, Double multiplicador) {
        this.nome = nome;
        this.preco = preco;
        this.aluguelBase = aluguelBase;
        this.multiplicador = multiplicador;
    }

    @Override
    public String toString() {
        return nome;

    }

    @Override
    public void acao(Jogador jogador) {
        double aluguelAtual = aluguelBase * multiplicador;

        //Sistema de compra
        System.out.println("#" + jogador.getNome() + " caiu no imóvel " + this.nome);
        if (this.dono == null){

            System.out.println("Este imóvel não tem um proprietário, deseja comprar por R$" + this.preco + "?");
            System.out.println("S. sim\nN. não");
            String escolha = input.next().toLowerCase().trim();

            switch (escolha){
                case "s":
                    if (jogador.getSaldo() >= this.preco){
                        System.out.println("Imóvel adquirido");
                        jogador.removerSaldo(preco);
                        this.dono = jogador;
                        this.dono.getPropriedades().add(this);
                    } else {
                        System.out.println("Dinheiro insuficiente para comprar a propriedade");
                    }
                    break;

                case "n":
                    System.out.println("O imóvel não foi comprado");
                    break;
                default:
                    System.out.println("Opção inválida, o imóvel não foi comprado");
                    break;
            }

        //Caiu na própria casa
        } else if (dono == jogador) {
            System.out.println(jogador.getNome() + " já é dono da propriedade " + this.nome + " não precisa pagar o aluguel");
        }

        else {
            double pagarAluguel = aluguelAtual * jogador.getProfissao().getMultiAluguelPago() * dono.getProfissao().getMultiAluguelRecebido();

            System.out.println("A propriedade " + this.nome + " pertence a " + dono.getNome() + ", você pagou o aluguel de R$" + String.format("%.2f", pagarAluguel));
            jogador.removerSaldo(pagarAluguel);
            dono.adicionarSaldo(pagarAluguel);
        }

        //Acréscimo de aluguel
        if (jogador != dono){
            if (this.multiplicador > 2) {
                System.out.println("O aluguel já está em seu valor máximo");
            } else {
                this.multiplicador += 0.1;
            }
        }
    }

    public void perdeuDono(){
        this.dono = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getAluguelBase() {
        return aluguelBase;
    }

    public void setAluguelBase(Double aluguelBase) {
        this.aluguelBase = aluguelBase;
    }

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }

    public Double getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(Double multiplicador) {
        this.multiplicador = multiplicador;
    }
}
