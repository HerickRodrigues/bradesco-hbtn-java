import java.util.ArrayList;

public class GestaoAlunos {

    private ArrayList<Aluno> alunos;

    public GestaoAlunos() {
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(String nome, int idade, String curso) {
        Aluno novoAluno = new Aluno(nome, idade);
        alunos.add(novoAluno);
        System.out.println("Aluno " + nome + " adicionado com sucesso!");
    }

    public boolean excluirAluno(String nome) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getNome().equalsIgnoreCase(nome)) {
                alunos.remove(i);
                System.out.println("Aluno " + nome + " removido com sucesso!");
                return true;
            }
        }
        System.out.println("Aluno " + nome + " não encontrado!");
        return false;
    }

    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + aluno);
                return;
            }
        }
        System.out.println("Aluno " + nome + " não encontrado!");
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        
        System.out.println("Lista de alunos cadastrados:");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println((i + 1) + ". " + alunos.get(i));
        }
    }

    public int getTotalAlunos() {
        return alunos.size();
    }
}
