import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

record Transaction(String id, String date, int amount, String category) {}

public class CsvTransactionAnalyzer {
    public static void main(String[] args) {
        String fileName = "transaction.csv";

        try {
            int totalFood = Files.lines(Paths.get(fileName))
                .skip(1)
                .map(line -> {
                    String[] parts = line.split(",");
                    return new Transaction(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
                })
                .filter(t -> t.category().equalsIgnoreCase("Food"))
                .mapToInt(t -> t.amount())
                .sum();

                System.out.println("Total pengeluaran Makanan: Rp " + totalFood);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
