import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String filePath = "funcionarios.csv";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            boolean isFirst = true;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] fields = line.split(",");
                if (isFirst) {
                    System.out.println("Funcionário: " + fields[0]);
                    System.out.println("Idade: " + fields[1]);
                    System.out.println("Departamento: " + fields[2]);
                    System.out.println("Salarial: " + fields[3]);
                    System.out.println("------------------------");
                    isFirst = false;
                    continue;
                }
                System.out.println("Funcionário: " + fields[0]);
                System.out.println("Idade: " + fields[1]);
                System.out.println("Departamento: " + fields[2]);
                System.out.println("Salarial: " + fields[3]);
                System.out.println("------------------------");
            }
            System.out.println("Leitura do arquivo concluída.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
