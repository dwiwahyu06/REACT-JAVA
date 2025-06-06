import java.util.ArrayList;

public class Mahasiswa extends orang {
    private String jurusan;

    public Mahasiswa(String nama, String id, String jurusan) {
        super(nama, id);
        this.jurusan = jurusan;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public void display() {
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getId());
        System.out.println("Jurusan: " + jurusan);
    }
}
