import java.util.Scanner;

public class Kuis1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;
        double angka1, angka2, hasil;

        do {
            System.out.println("===Kalkulator  Sederhana===");
            System.out.println("1. Tambah");
            System.out.println("2. Kurang");
            System.out.println("3. Kali");
            System.out.println("4. Bagi");
            System.out.println("5. Keluar");
            System.out.print("Pilih Operasi (1-5): ");
            pilihan = input.nextInt();

            if (pilihan >= 1 && pilihan <= 4) {
                System.out.print("Masukan angka pertama : ");
                angka1 = input.nextDouble();
                System.out.print("Masukan angka kedua   : ");
                angka2 = input.nextDouble();

                switch (pilihan) {
                    case 1:
                        hasil = angka1 + angka2;
                        break;
                    case 2:
                        hasil = angka1 - angka2;
                        break;
                    case 3:
                        hasil = angka1 * angka2;
                        break;
                    case 4:
                        if (angka2 == 0) {
                            System.out.println("Tidak bisa dibagi dengan nol!");
                            continue;
                        } else {
                            hasil = angka1 / angka2;
                        }
                        break;
                    default:
                        hasil = 0;
                }
                System.out.printf("Hasil : %.1f\n\n", hasil);
            } else if (pilihan == 5) {
                System.out.println("Selesai");
            } else {
                System.out.println("Pilihan tidak valid!\n");
            }

        } while (pilihan != 5);

        input.close();
    }
}
