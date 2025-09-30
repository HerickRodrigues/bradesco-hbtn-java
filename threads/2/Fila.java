import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    private Queue<Integer> fila;
    private int capacidade;
    
    public Fila(int capacidade) {
        this.fila = new LinkedList<>();
        this.capacidade = capacidade;
    }
    
    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() >= capacidade) {
            System.out.println("Fila cheia. Produtor aguardando.");
            wait();
        }
        fila.offer(item);
        System.out.println("Produtor adicionou: " + item + " | Tamanho da fila: " + fila.size());
        notifyAll();
    }
    
    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            System.out.println("Fila vazia. Consumidor aguardando.");
            wait();
        }
        int item = fila.poll();
        System.out.println("Consumidor retirou: " + item + " | Tamanho da fila: " + fila.size());
        notifyAll();
        return item;
    }
    
    public synchronized int tamanho() {
        return fila.size();
    }
}
