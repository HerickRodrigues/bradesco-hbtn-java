import java.util.Locale;

public class Pessoa implements Comparable<Pessoa> {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;
    
    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return String.format(new Locale("pt", "BR"), "[%d] %s %s %d R$ %.6f", codigo, nome, cargo, idade, salario);
    }

    @Override
    public int compareTo(Pessoa outra) {
        return this.nome.compareTo(outra.nome);
    }
}