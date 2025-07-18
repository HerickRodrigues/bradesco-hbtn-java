public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double valorFinal = 0;
        for(ItemPedido item: itens) {
            double valorPorItem = item.getQuantidade() * item.getProduto().obterPrecoLiquido();
            valorFinal += valorPorItem;
        }
        double desconto = valorFinal * (percentualDesconto / 100);
        return valorFinal - desconto;
    }
}
