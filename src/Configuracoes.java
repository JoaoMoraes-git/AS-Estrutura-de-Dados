import java.util.ArrayList;
import java.util.Scanner;

public class Configuracoes {
    //Dados iniciais
    private double saldoInicial = 2500.00;
    private double salarioBase = 1000.00;
    private int turnos = 10;

    private ArrayList<Jogador> jogadoresCadastrados = new ArrayList<>();
    private ArrayList<Imovel> imoveisCadastrados = new ArrayList<>();
    private PilhaCarta baralho = new PilhaCarta();

    private String tempNome;
    private double tempPreco;
    private double tempAluguel;
    private String tempNomeJ;
    private int tempProfissao;

    Scanner input = new Scanner(System.in);

    //Dados já preenchidos para conseguir jogar direto sem configurar
    Profissao profEspeculador = new Profissao("Especulador", 1.2, 1.1, 1.0, 1.0);
    Profissao profNegociante = new Profissao("Negociante", 1.0, 1.0, 0.9, 1.0);
    Profissao profAdvogado = new Profissao("Advogado", 1.0, 0.0, 1.0, 1.0);
    Profissao profConstrutor = new Profissao("Construtor", 1.0, 1.0, 1.0, 1.15);

    public Configuracoes() {
        configPadrao();
    }

    private void configPadrao() {
        jogadoresCadastrados.add(new Jogador("Eze Peculador", profEspeculador, saldoInicial));
        jogadoresCadastrados.add(new Jogador("Shopi Kepp", profNegociante, saldoInicial));
        jogadoresCadastrados.add(new Jogador("Fênix Veríssimo", profAdvogado, saldoInicial));
        jogadoresCadastrados.add(new Jogador("Leo Go", profConstrutor, saldoInicial));

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

    //Customiza imóveis, jogadores e regras do jogo
    public void configurar() {
        boolean configurando = true;
        int escolha;

        while (configurando) {
            System.out.println("\n-- CONFIGURAÇÕES PRÉ-JOGO --");
            System.out.println("1. Gerenciar Imóveis (" + imoveisCadastrados.size() + "/40)");
            System.out.println("2. Gerenciar Jogadores (" + jogadoresCadastrados.size() + "/6)");
            System.out.println("3. Configurações da Partida");
            System.out.println("4. INICIAR PARTIDA");
            System.out.print("Escolha: ");
            escolha = input.nextInt();

            switch (escolha) {

                case 1:
                    System.out.println("\n1. Cadastrar imóvel\n2. Listar imóveis\n3. Atualizar imóvel\n4. Remover imóvel");
                    escolha = input.nextInt();

                    switch (escolha) {
                        case 1:
                            if (imoveisCadastrados.size() >= 40) {
                                System.out.println("! Máximo de 40 imóveis já cadastrados.");
                            } else {
                                System.out.println("- Cadastrando novo imóvel -");
                                camposImovel();
                                imoveisCadastrados.add(new Imovel(tempNome, tempPreco, tempAluguel, 1.0));
                                System.out.println("CADASTRADO COM SUCESSO!");
                            }
                            break;
                        case 2:
                            System.out.println("- Lista de Imóveis -");
                            for (int i = 0; i < imoveisCadastrados.size(); i++) {
                                System.out.println("[" + i + "] " + imoveisCadastrados.get(i).toString());
                            }
                            break;
                        case 3:
                            if (imoveisCadastrados.size() == 0) {
                                System.out.println("! Nenhum imóvel cadastrado.");
                            } else {
                                System.out.print("Digite o índice do imóvel para atualizar: ");
                                int indice = input.nextInt();
                                if (indice >= 0 && indice < imoveisCadastrados.size()) {
                                    camposImovel();
                                    imoveisCadastrados.set(indice, new Imovel(tempNome, tempPreco, tempAluguel, 1.0));
                                    System.out.println("ATUALIZADO COM SUCESSO!");
                                } else {
                                    System.out.println("Índice não encontrado.");
                                }
                            }
                            break;
                        case 4:
                            if (imoveisCadastrados.size() == 0) {
                                System.out.println("! Nenhum imóvel cadastrado.");
                            } else {
                                System.out.print("Digite o índice do imóvel para remover: ");
                                int indice = input.nextInt();
                                if (indice >= 0 && indice < imoveisCadastrados.size()) {
                                    imoveisCadastrados.remove(indice);
                                    System.out.println("REMOVIDO COM SUCESSO!");
                                } else {
                                    System.out.println("Índice não encontrado.");
                                }
                            }
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\n1. Cadastrar jogador\n2. Listar jogadores\n3. Atualizar jogador\n4. Remover jogador");
                    escolha = input.nextInt();

                    switch (escolha) {
                        case 1:
                            if (jogadoresCadastrados.size() >= 6) {
                                System.out.println("! Máximo de 6 jogadores já cadastrados.");
                            } else {
                                System.out.println("- Cadastrando novo jogador -");
                                campoJogador();
                                adicionarJogadorNaLista(tempProfissao);
                            }
                            break;
                        case 2:
                            System.out.println("- Lista de Jogadores -");
                            for (int i = 0; i < jogadoresCadastrados.size(); i++) {
                                Jogador j = jogadoresCadastrados.get(i);
                                System.out.println("[" + i + "] " + j.getNome() + " | Profissão: " + j.getProfissao().getTitulo());
                            }
                            break;
                        case 3:
                            if (jogadoresCadastrados.size() == 0) {
                                System.out.println("! Nenhum jogador cadastrado.");
                            } else {
                                System.out.print("Digite o índice do jogador para atualizar: ");
                                int indice = input.nextInt();
                                if (indice >= 0 && indice < jogadoresCadastrados.size()) {
                                    campoJogador();
                                    atualizarJogadorNaLista(indice, tempProfissao);
                                } else {
                                    System.out.println("Índice não encontrado.");
                                }
                            }
                            break;
                        case 4:
                            if (jogadoresCadastrados.size() == 0) {
                                System.out.println("! Nenhum jogador cadastrado.");
                            } else {
                                System.out.print("Digite o índice do jogador para remover: ");
                                int indice = input.nextInt();
                                if (indice >= 0 && indice < jogadoresCadastrados.size()) {
                                    jogadoresCadastrados.remove(indice);
                                    System.out.println("REMOVIDO COM SUCESSO!");
                                } else {
                                    System.out.println("Índice não encontrado.");
                                }
                            }
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("\n-- REGRAS DA PARTIDA --");
                    System.out.println("1. Alterar Saldo Inicial (Atual: R$" + saldoInicial + ")");
                    System.out.println("2. Alterar Salário Base (Atual: R$" + salarioBase + ")");
                    System.out.println("3. Alterar Número de Turnos (Atual: " + turnos + ")");
                    escolha = input.nextInt();

                    switch (escolha) {
                        case 1:
                            System.out.print("Novo saldo inicial: R$");
                            saldoInicial = input.nextDouble();

                            for (Jogador j : jogadoresCadastrados) {
                                j.saldo = saldoInicial;
                            }
                            System.out.println("Saldo inicial atualizado para todos os jogadores!");
                            break;
                        case 2:
                            System.out.print("Novo salário base: R$");
                            salarioBase = input.nextDouble();
                            break;
                        case 3:
                            System.out.print("Novo número de turnos: ");
                            turnos = input.nextInt();
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;

                case 4:
                    if (jogadoresCadastrados.size() < 2) {
                        System.out.println("ERRO: É necessário no mínimo 2 jogadores para iniciar.");
                    } else if (imoveisCadastrados.size() < 10) {
                        System.out.println("ERRO: É necessário no mínimo 10 imóveis cadastrados para iniciar.");
                    } else {
                        System.out.println("\n>>> Tudo pronto! Iniciando a partida... <<<");
                        configurando = false;
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public void camposImovel() {
        input.nextLine();
        System.out.println("Digite o título do imóvel:");
        tempNome = input.nextLine();
        System.out.println("Digite o preço do imóvel:");
        tempPreco = input.nextDouble();
        System.out.println("Digite o novo aluguel base do imóvel:");
        tempAluguel = input.nextDouble();
    }

    public void campoJogador() {
        input.nextLine();
        System.out.println("Digite o nome do jogador:");
        tempNomeJ = input.nextLine();
        System.out.println("Qual profissão? 1. Especulador | 2. Negociante | 3. Advogado | 4. Construtor");
        tempProfissao = input.nextInt();
    }

    private void adicionarJogadorNaLista(int prof) {
        switch (prof) {
            case 1: jogadoresCadastrados.add(new Jogador(tempNomeJ, profEspeculador, saldoInicial)); break;
            case 2: jogadoresCadastrados.add(new Jogador(tempNomeJ, profNegociante, saldoInicial)); break;
            case 3: jogadoresCadastrados.add(new Jogador(tempNomeJ, profAdvogado, saldoInicial)); break;
            case 4: jogadoresCadastrados.add(new Jogador(tempNomeJ, profConstrutor, saldoInicial)); break;
            default: System.out.println("Profissão inválida. Jogador não cadastrado."); return;
        }
        System.out.println("JOGADOR CADASTRADO!");
    }

    private void atualizarJogadorNaLista(int indice, int prof) {
        switch (prof) {
            case 1: jogadoresCadastrados.set(indice, new Jogador(tempNomeJ, profEspeculador, saldoInicial)); break;
            case 2: jogadoresCadastrados.set(indice, new Jogador(tempNomeJ, profNegociante, saldoInicial)); break;
            case 3: jogadoresCadastrados.set(indice, new Jogador(tempNomeJ, profAdvogado, saldoInicial)); break;
            case 4: jogadoresCadastrados.set(indice, new Jogador(tempNomeJ, profConstrutor, saldoInicial)); break;
            default: System.out.println("Profissão inválida. Jogador não atualizado."); return;
        }
        System.out.println("ATUALIZADO COM SUCESSO!");
    }

    public ArrayList<Jogador> getJogadoresCadastrados() { return jogadoresCadastrados; }
    public ArrayList<Imovel> getImoveisCadastrados() { return imoveisCadastrados; }
    public double getSalarioBase() { return salarioBase; }
    public int getTurnos() { return turnos; }
}