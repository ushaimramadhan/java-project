import java.util.Scanner;

public class StringAnalyzer {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== STRING ANALYZER ===");
        System.out.print("Masukkan sebuah kalimat: ");
        String input = scanner.nextLine();

        System.out.println("\n--- Hasil Analisis ---");
        System.out.println("Input: " + input);

        int jumlahVokal = hitungVokal(input);
        System.out.println("Jumlah Huruf vokal: " + jumlahVokal);

        int jumlahChar = hitungKarakter(input);
        System.out.println("Jumlah Karakter (No Spasi): " + jumlahChar);

        String terbalik = balikKalimat(input);
        System.out.println("Dibalik: " + terbalik);

        scanner.close();
    }

    public static int hitungVokal(String teks) {
        int count = 0;
        teks = teks.toLowerCase();

        for (int i=0; i<teks.length(); i++) {
            char c = teks.charAt(i);
            if (c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o') {
                count++;
            } 
        }
        return count;
    }

    public static int hitungKarakter(String teks) {
        int count = 0;

        for (int i=0; i<teks.length(); i++) {
            if (teks.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }

    public static String balikKalimat(String teks) {
        String hasil = "";

        for (int i = teks.length() - 1; i>=0; i--) {
            hasil += teks.charAt(i);
        }
        return hasil;
    }
}
