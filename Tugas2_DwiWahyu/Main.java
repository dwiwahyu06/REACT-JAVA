import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();

        HashMap<String, Dosen> mapDosen = new HashMap<>();

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Masukkan data mahasiswa ke-" + (i + 1));
            System.out.print("Nama: ");
            String nama = input.nextLine();
            System.out.print("NIM: ");
            String nim = input.nextLine();
            System.out.print("Jurusan: ");
            String jurusan = input.nextLine();

            Mahasiswa mhs = new Mahasiswa(nama, nim, jurusan);
            listMahasiswa.add(mhs);
        }

        System.out.print("Masukkan jumlah dosen: ");
        int jumlahDosen = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlahDosen; i++) {
            System.out.println("Masukkan data dosen ke-" + (i + 1));
            System.out.print("Nama: ");
            String nama = input.nextLine();
            System.out.print("NIP: ");
            String nip = input.nextLine();
            System.out.print("Bidang: ");
            String bidang = input.nextLine();

            Dosen dsn = new Dosen(nama, nip, bidang);
            mapDosen.put(nip, dsn);
        }

        System.out.println("\n=== DATA MAHASISWA ===");
        for (Mahasiswa mhs : listMahasiswa) {
            mhs.display();
            System.out.println();
        }

        System.out.println("=== DATA DOSEN ===");
        for (String nip : mapDosen.keySet()) {
            Dosen dsn = mapDosen.get(nip);
            dsn.display();
            System.out.println();
        }
    }
}
