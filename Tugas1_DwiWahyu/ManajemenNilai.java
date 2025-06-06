import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenNilai {
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> namaMahasiswa = new ArrayList<>();
    static ArrayList<String> nimMahasiswa = new ArrayList<>();
    static ArrayList<Double> nilaiTugas = new ArrayList<>();
    static ArrayList<Double> nilaiUTS = new ArrayList<>();
    static ArrayList<Double> nilaiUAS = new ArrayList<>();
    static ArrayList<Double> nilaiAkhir = new ArrayList<>();
    static ArrayList<String> grade = new ArrayList<>();

    public static void main(String[] args) {
        int pilih;
        do {
            tampilMenu();
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine(); 
            switch (pilih) {
                case 1:
                    inputData();
                    break;
                case 2:
                    tampilData();
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                case 4:
                    cariMahasiswa();
                    break;
                case 5:
                    hapusMahasiswa();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 3);
    }

    static void tampilMenu() {
        System.out.println("=== MENU MANAJEMEN NILAI MAHASISWA ===");
        System.out.println("1. Input Data Mahasiswa");
        System.out.println("2. Tampilkan Data Mahasiswa");
        System.out.println("3. Keluar");
        System.out.println("4. Cari Mahasiswa berdasarkan NIM");
        System.out.println("5. Hapus Data Mahasiswa berdasarkan NIM");
    }

    static void inputData() {
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = input.nextInt();
        input.nextLine(); 

        for (int i = 0; i < jumlah; i++) {
            System.out.println("Mahasiswa ke-" + (i + 1));
            System.out.print("Nama        : ");
            String nama = input.nextLine();
            System.out.print("NIM         : ");
            String nim = input.nextLine();

            double tugas, uts, uas;
            do {
                System.out.print("Nilai Tugas : ");
                tugas = input.nextDouble();
            } while (tugas < 0 || tugas > 100);
            do {
                System.out.print("Nilai UTS   : ");
                uts = input.nextDouble();
            } while (uts < 0 || uts > 100);
            do {
                System.out.print("Nilai UAS   : ");
                uas = input.nextDouble();
            } while (uas < 0 || uas > 100);

            double akhir = hitungNilaiAkhir(tugas, uts, uas);
            String huruf = tentukanGrade(akhir);

            namaMahasiswa.add(nama);
            nimMahasiswa.add(nim);
            nilaiTugas.add(tugas);
            nilaiUTS.add(uts);
            nilaiUAS.add(uas);
            nilaiAkhir.add(akhir);
            grade.add(huruf);

            input.nextLine();
        }
    }

    static double hitungNilaiAkhir(double tugas, double uts, double uas) {
        return (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);
    }

    static String tentukanGrade(double nilai) {
        if (nilai >= 80) {
            return "A";
        } else if (nilai >= 70) {
            return "B";
        } else if (nilai >= 60) {
            return "C";
        } else if (nilai >= 50) {
            return "D";
        } else {
            return "E";
        }
    }

    static void tampilData() {
        System.out.println("=== DATA MAHASISWA ===");
        if (namaMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
        } else {
            for (int i = 0; i < namaMahasiswa.size(); i++) {
                System.out.println("Mahasiswa ke-" + (i + 1));
                System.out.println("Nama        : " + namaMahasiswa.get(i));
                System.out.println("NIM         : " + nimMahasiswa.get(i));
                System.out.println("Nilai Tugas : " + nilaiTugas.get(i));
                System.out.println("Nilai UTS   : " + nilaiUTS.get(i));
                System.out.println("Nilai UAS   : " + nilaiUAS.get(i));
                System.out.println("Nilai Akhir : " + nilaiAkhir.get(i));
                System.out.println("Grade       : " + grade.get(i));
                System.out.println("------------------------------");
            }
        }
    }

    static void cariMahasiswa() {
        if (nimMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
        } else {
            System.out.print("Masukkan NIM yang dicari: ");
            String cariNIM = input.nextLine();
            boolean ketemu = false;

            for (int i = 0; i < nimMahasiswa.size(); i++) {
                if (nimMahasiswa.get(i).equalsIgnoreCase(cariNIM)) {
                    System.out.println("Data ditemukan:");
                    System.out.println("Nama        : " + namaMahasiswa.get(i));
                    System.out.println("NIM         : " + nimMahasiswa.get(i));
                    System.out.println("Nilai Tugas : " + nilaiTugas.get(i));
                    System.out.println("Nilai UTS   : " + nilaiUTS.get(i));
                    System.out.println("Nilai UAS   : " + nilaiUAS.get(i));
                    System.out.println("Nilai Akhir : " + nilaiAkhir.get(i));
                    System.out.println("Grade       : " + grade.get(i));
                    ketemu = true;
                    break;
                }
            }

            if (!ketemu) {
                System.out.println("Data dengan NIM " + cariNIM + " tidak ditemukan.");
            }
        }
    }

    static void hapusMahasiswa() {
        if (nimMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
        } else {
            System.out.print("Masukkan NIM yang akan dihapus: ");
            String hapusNIM = input.nextLine();
            boolean ketemu = false;

            for (int i = 0; i < nimMahasiswa.size(); i++) {
                if (nimMahasiswa.get(i).equalsIgnoreCase(hapusNIM)) {

                    namaMahasiswa.remove(i);
                    nimMahasiswa.remove(i);
                    nilaiTugas.remove(i);
                    nilaiUTS.remove(i);
                    nilaiUAS.remove(i);
                    nilaiAkhir.remove(i);
                    grade.remove(i);
                    System.out.println("Data dengan NIM " + hapusNIM + " berhasil dihapus.");
                    ketemu = true;
                    break;
                }
            }

            if (!ketemu) {
                System.out.println("Data dengan NIM " + hapusNIM + " tidak ditemukan.");
            }
        }
    }
}
