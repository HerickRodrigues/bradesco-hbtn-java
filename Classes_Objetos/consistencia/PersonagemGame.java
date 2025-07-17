public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    public PersonagemGame(int saudeAtualInicial, String nome) {
        this.saudeAtual = saudeAtualInicial;
        this.nome = nome;
        setSaudeAtual(saudeAtualInicial);
    }

    public int getSaudeAtual() {
        return this.saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
        if(this.saudeAtual > 0) {
            this.status = "vivo";
        } else {
            this.status = "morto";
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        if(novoNome != null && novoNome != "") {
            this.nome = novoNome;
        }
    }

    public String getStatus() {
        return this.status;
    }

    public void tomarDano(int quantidadeDeDano) {
        int saudeFinal = saudeAtual - quantidadeDeDano;
        if(saudeFinal >= 0) {
            setSaudeAtual(saudeFinal);
        } else {
            setSaudeAtual(0);
        }
    }

    public void receberCura(int quantidadeDeCura) {
        int saudeFinal = saudeAtual + quantidadeDeCura;
        if(saudeFinal <= 100) {
            setSaudeAtual(saudeFinal);
        } else {
            setSaudeAtual(100);
        }
    }
}
