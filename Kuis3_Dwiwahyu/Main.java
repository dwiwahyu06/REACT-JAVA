import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Taambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    tampilkanMahasiswa();
                    break;
                case 3:
                    updateMahasiswa();
                    break;
                case 4:
                    hapusMahasiswa();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    public static void tambahMahasiswa() {
        Mahasiswa mhs = new Mahasiswa();

        System.out.print("Masukkan nama: ");
        mhs.setNama(scanner.nextLine());

        System.out.print("Masukkan umur: ");
        mhs.setUmur(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Masukkan NIM: ");
        mhs.setNim(scanner.nextLine());

        daftarMahasiswa.add(mhs);
        System.out.println("Data berhasil ditambahkan.");
    }

    public static void tampilkanMahasiswa() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada data .");
        } else {
            for (int i = 0; i < daftarMahasiswa.size(); i++) {
                System.out.println("\nData Mahasiswa ke-" + (i + 1));
                daftarMahasiswa.get(i).displayInfo();
            }
        }
    }

    public static void updateMahasiswa() {
        tampilkanMahasiswa();

        if (!daftarMahasiswa.isEmpty()) {
            System.out.print("\nPilih nomor yang akan diubah: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < daftarMahasiswa.size()) {
                Mahasiswa mhs = daftarMahasiswa.get(index);

                System.out.print("Nama baru: ");
                mhs.setNama(scanner.nextLine());

                System.out.print("Umur baru: ");
                mhs.setUmur(scanner.nextInt());
                scanner.nextLine();

                System.out.print("NIM baru: ");
                mhs.setNim(scanner.nextLine());

                System.out.println("Data berhasil diperbarui.");
            } else {
                System.out.println("Nomor tidak valid.");
            }
        }
    }

    public static void hapusMahasiswa() {
        tampilkanMahasiswa();

        if (!daftarMahasiswa.isEmpty()) {
            System.out.print("\nPilih nomor  yang akan dihapus: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < daftarMahasiswa.size()) {
                daftarMahasiswa.remove(index);
                System.out.println("Data berhasil dihapus.");
            } else {
                System.out.println("Nomor tidak valid.");
            }
        }
    }
}
