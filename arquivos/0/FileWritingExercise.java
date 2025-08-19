import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String line;
            while (true) {
                System.out.print("Digite uma linha de texto (ou 'sair' para finalizar): ");
                line = scanner.nextLine();
                if (line.equalsIgnoreCase("sair")) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Arquivo '" + fileName + "' criado e conteúdo salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}
