package buatDatabase;

public class dataMahasiswa {
    private String nim;
    private String nama;
    private String alamat;
    private int semester;
    private int sks;
    private double ipk;

    public dataMahasiswa(String nim, String nama, String alamat, int semester, int sks, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.semester = semester;
        this.sks = sks;
        this.ipk = ipk;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getSemester() {
        return semester;
    }

    public int getSks() {
        return sks;
    }

    public double getIpk() {
        return ipk;
    }

    @Override
    public String toString() {
        return "writerText{" +
                "NIM='" + nim + '\'' +
                ", nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                ", semester=" + semester +
                ", sks=" + sks +
                ", ipk=" + ipk +
                '}';
    }
}