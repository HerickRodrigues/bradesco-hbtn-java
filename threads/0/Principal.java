public class Principal {
        public static void main(String[] args) {
        Contador contador = new Contador();
        
        // Criar duas threads que incrementam o contador 1000 vezes cada
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        });
        
        // Iniciar as threads
        thread1.start();
        thread2.start();
        
        try {
            // Aguardar as threads terminarem
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Imprimir o valor final
        System.out.println("Valor final do contador: " + contador.getContagem());
    }
}
