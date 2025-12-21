import java.util.Scanner;

public class Kalkulator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("== KALKULATOR SEDERHANA ===");

        System.out.print("Masukkan angka pertama: ");
        int angka1 = scanner.nextInt();

        System.out.print("Masukkan angka kedua: ");
        int angka2 = scanner.nextInt();

        System.out.println("\nPilih Operasi:");
        System.out.println("1. Tambah");
        System.out.println("2. Kurang");
        System.out.println("3. kali");
        System.out.println("4. Bagi");
        System.out.print("Pilihan Anda: ");
        String operator = scanner.next();

        System.out.println("Hasil: ");

        switch (operator) {
            case "1":
                System.out.println(tambah(angka1, angka2));
                break;
            case "2":
                System.out.println(kurang(angka1, angka2));
                break;
            case "3":
                System.out.println(kali(angka1, angka2));
                break;
            case "4":
                if (angka2 == 0) {
                    System.out.println("Error! tidak bisa membagi dengan angka 0");   
                } else {
                    System.out.println(bagi(angka1, angka2));
                }
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        } 
        scanner.close();
    }

    public static int tambah(int a, int b) {
        return a+b;
    }

    public static int kurang(int a, int b) {
        return a-b;
    }

    public static int kali(int a, int b) {
        return a*b;
    }

    public static double bagi(double a, double b) {
        return a/b;
    }
}
