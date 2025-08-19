import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingExercise {
    public static void main(String[] args) {
        String fileName = "exemplo.txt"; // Nome do arquivo fixo para leitura

        System.out.println("Conteúdo do arquivo 'exemplo.txt':\n");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }
        System.out.println("\nLeitura do arquivo concluída.");
    }
}
