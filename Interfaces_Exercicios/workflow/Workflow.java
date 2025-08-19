
package Interfaces_Exercicios.workflow;

import java.util.ArrayList;
import java.util.List;
import Interfaces_Exercicios.workflow.atividades.Atividade;

public class Workflow {
    private List<Atividade> atividades = new ArrayList<>();

    public void registrarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }
}
