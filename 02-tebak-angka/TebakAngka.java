import java.util.Random;
import java.util.Scanner;

public class TebakAngka {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== GAME TEBAK ANGKA ===");
        System.out.println("Saya sudah memilih angka antara 1 sampai 100.");
        System.out.println("Coba tebak ya!");

        int targetAngka = random.nextInt(100) + 1;
        int tebakanUser = 0;
        int jumlahPercobaan = 0;

        while(tebakanUser != targetAngka) {
            System.out.print("\nMasukkan tebakanmu: ");
            tebakanUser = scanner.nextInt();
            jumlahPercobaan++;

            if (tebakanUser == targetAngka) {
                System.out.println("Selamat kamu berhasil menebak angkanya!");
                System.out.printf("Jumlah percobaan: %d \n", jumlahPercobaan);
            } else if (tebakanUser < targetAngka) {
                System.out.println("Terlalu kecil! coba lagi.");
            } else {
                System.out.println("Terlalu besar! coba lagi.");
            }
        }
        scanner.close();
    }
}
