public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if(departamento.alcancouMeta()) {
            double bonus = salarioFixo * 0.2;
            double diferencaResultado = (departamento.getValorAtingidoMeta() - departamento.getValorMeta()) * 0.01;
            return bonus + diferencaResultado;
        } else {
            return 0;
        }
    }
}
