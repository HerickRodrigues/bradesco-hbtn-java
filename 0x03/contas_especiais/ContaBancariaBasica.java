public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0.0;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
        if (valor > saldo) {
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        }
        saldo -= valor;
    }

    public double calcularTarifaMensal() {
        double tarifa = 10.0;
        double dezPorcento = saldo * 0.10;
        return Math.min(tarifa, dezPorcento);
    }

    public double calcularJurosMensal() {
        if (saldo < 0) {
            return 0.0;
        }
        double taxaMensal = taxaJurosAnual / 12.0 / 100.0;
        return saldo * taxaMensal;
    }

    public void aplicarAtualizacaoMensal() {
        double juros = 0.0;
        if (saldo >= 0) {
            double taxaMensal = taxaJurosAnual / 12.0 / 100.0;
            juros = saldo * taxaMensal;
            juros = Math.round(juros * 100.0) / 100.0;
        }
        saldo -= calcularTarifaMensal();
        saldo += juros;
        saldo = Math.round(saldo * 100.0) / 100.0;
    }
}
