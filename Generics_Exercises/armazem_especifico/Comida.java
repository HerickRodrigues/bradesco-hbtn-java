public class Comida {
    private String nome;
    private int calorias;
    private double preco;

    public Comida(String nome, int calorias, double preco) {
        this.nome = nome;
        this.calorias = calorias;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        String caloriasFormatadas = String.format("%.6f", (double)calorias).replace('.', ',');
        String precoFormatado = String.format("%.6f", preco).replace('.', ',');
        return "[" + nome + "] " + caloriasFormatadas + " R$ " + precoFormatado;
    }
}
