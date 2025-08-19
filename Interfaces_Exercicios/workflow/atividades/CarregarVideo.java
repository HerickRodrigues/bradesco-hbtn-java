package Interfaces_Exercicios.workflow.atividades;

public class CarregarVideo implements Atividade {
    @Override
    public void executar() {
        System.out.println("carregando video");
    }
}
