public class SistemaFilas {
    public static void main(String[] args) {
        Fila fila = new Fila(10);

        Produtor produtor1 = new Produtor(fila, "Produtor-1");
        Produtor produtor2 = new Produtor(fila, "Produtor-2");
        Consumidor consumidor1 = new Consumidor(fila, "Consumidor-1");
        Consumidor consumidor2 = new Consumidor(fila, "Consumidor-2");

        produtor1.start();
        produtor2.start();
        consumidor1.start();
        consumidor2.start();
        
        try {
            Thread.sleep(20000);

            produtor1.interrupt();
            produtor2.interrupt();
            consumidor1.interrupt();
            consumidor2.interrupt();

            produtor1.join();
            produtor2.join();
            consumidor1.join();
            consumidor2.join();
            
        } catch (InterruptedException e) {
            System.err.println("Thread principal foi interrompida: " + e.getMessage());
        }
        System.exit(0);
    }
}