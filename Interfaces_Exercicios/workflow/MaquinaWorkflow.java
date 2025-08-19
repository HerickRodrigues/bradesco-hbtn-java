
package Interfaces_Exercicios.workflow;

import Interfaces_Exercicios.workflow.atividades.Atividade;

public class MaquinaWorkflow {
    public void executar(Workflow workflow) {
        for (Atividade atividade : workflow.getAtividades()) {
            atividade.executar();
        }
    }
}
