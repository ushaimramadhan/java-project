import java.util.Random;
import java.util.Scanner;

public class TebakAngka {
    private static final int maxRange = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== GAME TEBAK ANGKA ===");
        System.out.println("Saya sudah memilih angka antara 1 sampai " + maxRange);
        System.out.println("Coba tebak ya!");

        int targetAngka = random.nextInt(maxRange) + 1;
        int tebakanUser;
        int jumlahPercobaan = 0;

        do {
            System.out.print("Masukkan tebakanmu: ");
            tebakanUser = scanner.nextInt();
            jumlahPercobaan++;

            if (tebakanUser == targetAngka) {
                System.out.println("Selamat tebakanmu benar!");
                System.out.println("Total percobaan: " + jumlahPercobaan);
            } else if (tebakanUser < targetAngka) {
                System.out.println("Terlalu kecil! coba lagi.");
            } else {
                System.out.println("Terlalu besar! coba lagi.");
            }
        } while (tebakanUser != targetAngka);

        scanner.close();
    }
}
