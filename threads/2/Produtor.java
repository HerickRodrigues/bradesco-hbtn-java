import java.util.Random;

public class Produtor extends Thread {
    private Fila fila;
    private String nome;
    private Random random;
    
    public Produtor(Fila fila, String nome) {
        this.fila = fila;
        this.nome = nome;
        this.random = new Random();
    }
    
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int numero = random.nextInt(100) + 1;
                fila.adicionar(numero);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(nome + " foi interrompido.");
            Thread.currentThread().interrupt();
        }
    }
}
