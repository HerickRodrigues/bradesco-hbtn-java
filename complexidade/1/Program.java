public class Program {

    public static void main(String[] args) {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            // Ignora se não suportar UTF-8
        }
        long inicio  = System.nanoTime();
        try {
            PessoasArray p = new PessoasArray();
            p.buscaLinear("Otavio");
            p.buscaLinear("Isabela");
            p.buscaLinear("Anderson");
        } finally {
            System.out.println("Tempo de execução: " + (System.nanoTime() - inicio));
        }
    }
}
