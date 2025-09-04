public class Program {

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        gestao.adicionarAluno("João Silva", 20, "Engenharia");
        gestao.adicionarAluno("Maria Santos", 22, "Medicina");
        gestao.adicionarAluno("Pedro Costa", 19, "Direito");
        
        System.out.println("\n--- Listando todos os alunos ---");
        gestao.listarAlunos();
        
        System.out.println("\n--- Buscando aluno específico ---");
        gestao.buscarAluno("Maria Santos");
        
        System.out.println("\n--- Excluindo aluno ---");
        gestao.excluirAluno("Pedro Costa");
        
        System.out.println("\n--- Lista após exclusão ---");
        gestao.listarAlunos();
        
        System.out.println("\n--- Tentando buscar aluno excluído ---");
        gestao.buscarAluno("Pedro Costa");
    }
}
