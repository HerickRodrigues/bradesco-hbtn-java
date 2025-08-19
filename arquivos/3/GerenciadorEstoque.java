
import java.util.Scanner;
import arquivos.3.Estoque;

public class GerenciadorEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque("estoque.csv");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Excluir Produto");
            System.out.println("3. Exibir Estoque");
            System.out.println("4. Atualizar Quantidade de Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = -1;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida!");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    int quantidade = 0;
                    double preco = 0.0;
                    try {
                        System.out.print("Digite a quantidade: ");
                        quantidade = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o preço: ");
                        preco = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Quantidade ou preço inválido!");
                        break;
                    }
                    estoque.adicionarProduto(nome, quantidade, preco);
                    break;
                case 2:
                    System.out.print("Digite o ID do produto a ser excluído: ");
                    int idExcluir = -1;
                    try {
                        idExcluir = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                        break;
                    }
                    estoque.excluirProduto(idExcluir);
                    break;
                case 3:
                    System.out.println("Estoque:");
                    estoque.exibirEstoque();
                    break;
                case 4:
                    System.out.print("Digite o ID do produto: ");
                    int idAtualizar = -1;
                    int novaQuantidade = 0;
                    try {
                        idAtualizar = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite a nova quantidade: ");
                        novaQuantidade = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID ou quantidade inválido!");
                        break;
                    }
                    estoque.atualizarQuantidade(idAtualizar, novaQuantidade);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
