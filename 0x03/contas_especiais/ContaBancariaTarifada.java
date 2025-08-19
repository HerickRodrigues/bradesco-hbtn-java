
public class ContaBancariaTarifada extends ContaBancariaBasica {
    private int quantidadeTransacoes = 0;
    private static final double TARIFA = 0.10;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        try {
            java.lang.reflect.Field f = ContaBancariaBasica.class.getDeclaredField("saldo");
            f.setAccessible(true);
            f.set(this, getSaldo() - TARIFA);
        } catch (Exception e) {}
        quantidadeTransacoes++;
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        try {
            java.lang.reflect.Field f = ContaBancariaBasica.class.getDeclaredField("saldo");
            f.setAccessible(true);
            f.set(this, getSaldo() - TARIFA);
        } catch (Exception e) {}
        quantidadeTransacoes++;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }
}
