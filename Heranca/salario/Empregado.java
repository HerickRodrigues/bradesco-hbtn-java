public class Empregado {
    double salarioFixo;

    public Empregado(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public double calcularBonus(Departamento departamento) {
        if(departamento.alcancouMeta()) {
            return salarioFixo * 0.1;
        } else {
            return 0;
        }
    }

    public double calcularSalarioTotal(Departamento departamento) {
        double bonus = calcularBonus(departamento);
        return salarioFixo + bonus;
    }
}
