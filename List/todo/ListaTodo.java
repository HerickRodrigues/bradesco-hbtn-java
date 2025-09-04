import java.util.ArrayList;
import java.util.List;

public class ListaTodo {
    private List<Tarefa> tarefas;

    public ListaTodo() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == tarefa.getIdentificador()) {
                throw new IllegalArgumentException("Tarefa com identificador " + tarefa.getIdentificador() + " ja existente na lista");
            }
        }
        tarefas.add(tarefa);
    }

    public boolean marcarTarefaFeita(int identificador) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == identificador) {
                t.setFeita(true);
                return true;
            }
        }
        return false;
    }

    public boolean desfazerTarefa(int identificador) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == identificador) {
                t.setFeita(false);
                return true;
            }
        }
        return false;
    }

    public void desfazerTodas() {
        for (Tarefa t : tarefas) {
            t.setFeita(false);
        }
    }

    public void fazerTodas() {
        for (Tarefa t : tarefas) {
            t.setFeita(true);
        }
    }

    public void listarTarefas() {
        for (Tarefa t : tarefas) {
            String status = t.isEstahFeita() ? "[X]" : "[ ]";
            System.out.println(String.format("%s  Id: %d - Descricao: %s", status, t.getIdentificador(), t.getDescricao()));
        }
    }
}
