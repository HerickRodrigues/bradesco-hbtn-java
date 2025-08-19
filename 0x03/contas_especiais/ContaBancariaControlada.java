
public class ContaBancariaControlada extends ContaBancariaBasica {
    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double taxaJurosAnual, double saldoMinimo, double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal() {
        super.aplicarAtualizacaoMensal();
        if (getSaldo() < saldoMinimo) {
            try {
                sacar(valorPenalidade);
            } catch (Exception e) {
                // saldo pode ficar negativo, força saldo negativo
                try {
                    java.lang.reflect.Field f = ContaBancariaBasica.class.getDeclaredField("saldo");
                    f.setAccessible(true);
                    f.set(this, getSaldo() - valorPenalidade);
                } catch (Exception ex) {}
            }
        }
    }
}
