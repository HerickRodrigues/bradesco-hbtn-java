public class PersonagemGame {
    private int saudeAtual;
    private String nome;

    public int getSaudeAtual() {
        return this.saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void tomarDano(int quantidadeDeDano) {
        int saudeFinal = saudeAtual - quantidadeDeDano;
        if(saudeFinal >= 0) {
            saudeAtual = saudeFinal;
        } else {
            saudeAtual = 0;
        }
    }

    public void receberCura(int quantidadeDeCura) {
        int saudeFinal = saudeAtual + quantidadeDeCura;
        if(saudeFinal <= 100) {
            saudeAtual = saudeFinal;
        } else {
            saudeAtual = 100;
        }
    }
}
