import java.util.Scanner;

public class Imovel implements TipoCasa{
    private String nome;
    private Double preco;
    private Double aluguel;
    private Jogador dono;
    private Double multiplicador;

    Scanner input = new Scanner(System.in);

    public Imovel(String nome, Double preco, Double aluguel, Double multiplicador) {
        this.nome = nome;
        this.preco = preco;
        this.aluguel = aluguel;
        this.multiplicador = multiplicador;
    }

    @Override
    public void acao(Jogador jogador) {
        System.out.println("#" + jogador.getNome() + " caiu no imóvel " + this.nome);
        if (this.dono == null){
            System.out.println("Este imóvel não tem um proprietário, deseja comprar por " + this.preco + "?");
            System.out.println("S. sim\nN. não");
            String escolha = input.nextLine().toLowerCase().trim();

            switch (escolha){
                case "s":
                    if (jogador.saldo >= this.preco){
                        System.out.println("Imóvel adquirido");
                        this.dono = jogador;
                        // Adicionar propriedade ao array do jogador
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

        }
    }
}
