public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double valorFinal = getValorFinal();
        double desconto = calcularDesconto(valorFinal);
        return valorFinal - desconto;
    }

    private double getValorFinal() {
        double valorFinal = 0;
        for(ItemPedido item: itens) {
            double valorPorItem = calcularValorPorItem(item);
            valorFinal += valorPorItem;
        }
        return valorFinal;
    }
    
    private double calcularValorPorItem(ItemPedido item) {
        return item.getQuantidade() * item.getProduto().obterPrecoLiquido();
    }
    
    private double calcularDesconto(double valorFinal) {
        return valorFinal * (percentualDesconto / 100);
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        for(ItemPedido item: itens) {
            System.out.println(String.format("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f", item.getProduto().getClass().getSimpleName(), item.getProduto().getTitulo(), item.getProduto().obterPrecoLiquido(), item.getQuantidade(), calcularValorPorItem(item)));
        }
        System.out.println("----------------------------");
        System.out.println(String.format("DESCONTO: %.2f", calcularDesconto(getValorFinal())));
        System.out.println(String.format("TOTAL PRODUTOS: %.2f", getValorFinal()));
        System.out.println("----------------------------");
        System.out.println(String.format("TOTAL PEDIDO: %.2f", calcularTotal()));
        System.out.println("----------------------------");
    }
}
