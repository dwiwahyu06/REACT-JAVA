public class orang {
    private String nama;
    private String id;

    public orang(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void display() {
        System.out.println("Nama: " + nama);
        System.out.println("ID: " + id);
    }
}
