import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

record Transaction(String id, String date, int amount, String category) {}

public class CsvTransactionAnalyzer {
    public static void main(String[] args) {
        String fileName = "transaction.csv";
        List<Transaction> transactions = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            lines.remove(0);

            for (String line : lines) {
                String[] parts = line.split(",");

                String id = parts[0];
                String date = parts[1];
                int amount = Integer.parseInt(parts[2]);
                String category = parts[3];

                transactions.add(new Transaction(id, date, amount, category));
            }

            System.out.println("Berhasil membaca " + transactions.size() + " transaksi.\n");

            for (Transaction t : transactions) {
                System.out.println(t);
            } 
        } catch (IOException e) {
            System.out.println("Error baca file: " + e.getMessage());
        }
    }    
}
