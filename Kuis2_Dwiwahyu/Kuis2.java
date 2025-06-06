import java.util.Scanner;

public class Kuis2 {

    static class Mahasiswa {

        private String nama;
        private String nim;
        private double ipk;

        public void setNama(String nama) {
            this.nama = nama;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }

        public void setIpk(double ipk) {
            this.ipk = ipk;
        }

        public String getNama() {
            return nama;
        }

        public String getNim() {
            return nim;
        }

        public double getIpk() {
            return ipk;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Mahasiswa mhs = new Mahasiswa();

        System.out.println("=== Inpuut Data Mahasiswa ===");
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();
        System.out.print("Masukkan IPK: ");
        double ipk = input.nextDouble();

        mhs.setNama(nama);
        mhs.setNim(nim);
        mhs.setIpk(ipk);

        System.out.println("\n=== Data Mahasiswa ===");
        System.out.println("Nama: " + mhs.getNama());
        System.out.println("NIM: " + mhs.getNim());
        System.out.println("IPK: " + mhs.getIpk());
    }
}
