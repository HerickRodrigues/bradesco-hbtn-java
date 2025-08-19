


import java.io.*;
import java.util.*;
// Importa Produto explicitamente


public class Estoque {
    private List<Produto> produtos;
    private String arquivoCsv;

    public Estoque(String arquivoCsv) {
        this.arquivoCsv = arquivoCsv;
        this.produtos = new ArrayList<>();
        carregarProdutos();
    }

    private void carregarProdutos() {
        produtos.clear();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoCsv), "UTF-8"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                if (campos.length == 4) {
                    int id = Integer.parseInt(campos[0]);
                    String nome = campos[1];
                    int quantidade = Integer.parseInt(campos[2]);
                    double preco = Double.parseDouble(campos[3]);
                    produtos.add(new Produto(id, nome, quantidade, preco));
                }
            }
        } catch (IOException e) {
            // Se o arquivo não existir, será criado ao salvar
        }
    }

    private void salvarProdutos() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivoCsv), "UTF-8"))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
    int novoId = gerarNovoId();
    Produto novoProduto = new Produto(novoId, nome, quantidade, preco);
    produtos.add(novoProduto);
    salvarProdutos();
    }

    private int gerarNovoId() {
        int maxId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }

    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            salvarProdutos();
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        boolean encontrado = false;
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            salvarProdutos();
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }
}
