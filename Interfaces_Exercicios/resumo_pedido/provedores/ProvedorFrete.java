package Interfaces_Exercicios.resumo_pedido.provedores;

public interface ProvedorFrete {
    Frete calcularFrete(double peso, double valor);
    TipoProvedorFrete obterTipoProvedorFrete();
}
