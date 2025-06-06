import java.util.HashMap;

public class Dosen extends orang {
    private String bidang;

    public Dosen(String nama, String id, String bidang) {
        super(nama, id);
        this.bidang = bidang;
    }

    public String getBidang() {
        return bidang;
    }

    public void setBidang(String bidang) {
        this.bidang = bidang;
    }

    @Override
    public void display() {
        System.out.println("Nama: " + getNama());
        System.out.println("NIP: " + getId());
        System.out.println("Bidang: " + bidang);
    }
}
