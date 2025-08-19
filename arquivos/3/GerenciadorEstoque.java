


import java.util.Scanner;

public class GerenciadorEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    Estoque estoque = new Estoque("d:/Documentos/Ambiente de dev/Bradesco Curso/bradesco-hbtn-java/arquivos/3/estoque.csv");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Excluir Produto");
            System.out.println("3. Exibir Estoque");
            System.out.println("4. Atualizar Quantidade de Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = lerInt(scanner);

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = lerInt(scanner);
                    System.out.print("Digite o preço: ");
                    double preco = lerDouble(scanner);
                    estoque.adicionarProduto(nome, quantidade, preco);
                    break;
                case 2:
                    System.out.print("Digite o ID do produto a ser excluído: ");
                    int idExcluir = lerInt(scanner);
                    estoque.excluirProduto(idExcluir);
                    break;
                case 3:
                    System.out.println("Estoque:");
                    estoque.exibirEstoque();
                    break;
                case 4:
                    System.out.print("Digite o ID do produto: ");
                    int idAtualizar = lerInt(scanner);
                    System.out.print("Digite a nova quantidade: ");
                    int novaQuantidade = lerInt(scanner);
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

    private static int lerInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Digite um número inteiro: ");
            }
        }
    }

    private static double lerDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Digite um número decimal: ");
            }
        }
    }
}
