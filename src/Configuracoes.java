import java.util.ArrayList;
import java.util.Scanner;

public class Configuracoes {
    private double saldoInicial = 2500.00;
    private double salarioBase = 1000.00;
    private int turnos = 10;

    private ArrayList<Jogador> jogadoresCadastrados = new ArrayList<>();
    private ArrayList<Imovel> imoveisCadastrados = new ArrayList<>();
    private PilhaCarta baralho = new PilhaCarta();

    private String tempNome;
    private double tempPreco;
    private double tempAluguel;

    Scanner input = new Scanner(System.in);


    //Roda sempre na main por padrão, depois o usuário pode mexer
    private void configPadrao(){

        Profissao profEspeculador = new Profissao("Especulador", 1.2, 1.1, 1.0, 1.0);
        Profissao profNegociante = new Profissao("Negociante", 1.0, 1.0, 0.9, 1.0);
        Profissao profAdvogado = new Profissao("Advogado", 1.0, 0.0, 1.0, 1.0);
        Profissao profConstrutor = new Profissao("Construtor", 1.0, 1.0, 1.0, 1.15);

        Jogador j1 = new Jogador("Eze Peculador", profEspeculador, 2500.00);
        Jogador j2 = new Jogador("Shopi Kepp", profNegociante, 2500.00);
        Jogador j3 = new Jogador("Fênix Veríssimo", profAdvogado, 2500.00);
        Jogador j4 = new Jogador("Leo Go", profConstrutor, 2500.00);

        jogadoresCadastrados.add(new Jogador("Eze Peculador", profEspeculador, 2500.00));
        jogadoresCadastrados.add(new Jogador("Shopi Kepp", profNegociante, 2500.00));
        jogadoresCadastrados.add(new Jogador("Fênix Veríssimo", profAdvogado, 2500.00));
        jogadoresCadastrados.add(new Jogador("Leo Go", profConstrutor, 2500.00));

        //TROCAR PARA AS PROPRIEDADES ATUAIS
        imoveisCadastrados.add(new Imovel("Chalé da Serra Gaúcha", 400.00, 50.00, 1.0));
        imoveisCadastrados.add(new Imovel("Flat Paulista", 600.00, 80.00, 1.0));
        imoveisCadastrados.add(new Imovel("Sobrado de Ouro Preto", 800.00, 100.00, 1.0));
        imoveisCadastrados.add(new Imovel("Pousada do Pantanal", 1000.00, 150.00, 1.0));
        imoveisCadastrados.add(new Imovel("Fazenda do Cerrado", 1200.00, 180.00, 1.0));
        imoveisCadastrados.add(new Imovel("Bangalô de Búzios", 1500.00, 250.00, 1.0));
        imoveisCadastrados.add(new Imovel("Casa de Bonito", 1800.00, 300.00, 1.0));
        imoveisCadastrados.add(new Imovel("Mansão de Gramado", 2200.00, 400.00, 1.0));
        imoveisCadastrados.add(new Imovel("Cobertura de Florianópolis", 2600.00, 500.00, 1.0));
        imoveisCadastrados.add(new Imovel("Penthouse de Salvador", 3000.00, 600.00, 1.0));
        imoveisCadastrados.add(new Imovel("Palacete de Petrópolis", 3500.00, 800.00, 1.0));
    }

    public void configurar(){
        boolean configurando = true;
        System.out.println("--CONFIGURAÇÕES INICIAIS--");
        int escolha;

        while(configurando){
            System.out.println("1. Propriedades\n2. Jogadores\n3. Partida");
            escolha = input.nextInt();

            switch (escolha){
                case 1:
                    for (int i = 0; i < imoveisCadastrados.size(); i++){
                        System.out.println("PRINTAR TODO O ARRAY AQUI JUNTO COM O SEU ÍNDICE"); //////////////////////////////

                        System.out.println("1. Cadastrar imóvel novo\n2. Atualizar imóvel\n3. Remover imóvel");
                        escolha = input.nextInt();

                        switch (escolha) {
                            case 1:
                                if (imoveisCadastrados.size() >= 40){
                                    System.out.println("! Máximo de imóveis já cadastrados");
                                } else {
                                    System.out.println("-Cadastrando novo imóvel-");
                                    camposImovel();
                                    imoveisCadastrados.add(new Imovel(tempNome, tempPreco, tempAluguel, 1.0));
                                    System.out.println("CADASTRADO COM SUCESSO");
                                    break;
                                }

                            case 2:
                                if (imoveisCadastrados.size() >= 0) {
                                    System.out.println("! Sem nenhum imóvel no momento para atualizar");
                                } else {
                                    System.out.println("-Atualizando imóvel-");
                                    System.out.println("Digite o índice do imóvel");
                                    int indice = input.nextInt();
                                    if (indice >= 0 && indice <= imoveisCadastrados.size() - 1){
                                        camposImovel();
                                        Imovel imovel = imoveisCadastrados.get(indice);
                                        imovel.setNome (tempNome);
                                        imovel.setPreco(tempPreco);
                                        imovel.setAluguelBase(tempAluguel);
                                        System.out.println("ATUALIZADO COM SUCESSO");

                                    } else {
                                        System.out.println("Índice não encontrado");
                                    }
                                }

                            case 3:
                                if (imoveisCadastrados.size() >= 0) {
                                    System.out.println("! Sem nenhum imóvel no momento para remover");
                                } else {
                                    System.out.println("-Removendo imóvel");
                                    System.out.println("Digite o índice do imóvel");
                                    int indice = input.nextInt();
                                    if (indice >= 0 && indice <= imoveisCadastrados.size() - 1){
                                        imoveisCadastrados.remove(indice);
                                        System.out.println("REMOVIDO COM SUCESSO");

                                    } else {
                                        System.out.println("Índice não encontrado");
                                    }
                                }
                                break;

                            default:
                                System.out.println("Opção inválida");
                                break;
                        }

                    }
                    break;

                case 2:
                    System.out.println("PLACEHOLDER");
                    break;

                case 3:
                    System.out.println("PLACEHOLDER");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }
    }

    public void camposImovel(){
        System.out.println("Digite o título do imóvel");
        tempNome = input.nextLine();
        System.out.println("Digite o preço do imóvel");
        tempPreco = input.nextDouble();
        System.out.println("Digite o novo aluguel base do imóvel");
        tempAluguel = input.nextDouble();
    }

}
