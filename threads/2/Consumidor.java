public class Consumidor extends Thread {
    private Fila fila;
    private String nome;
    
    public Consumidor(Fila fila, String nome) {
        this.fila = fila;
        this.nome = nome;
    }
    
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int numero = fila.retirar();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(nome + " foi interrompido.");
            Thread.currentThread().interrupt();
        }
    }
}