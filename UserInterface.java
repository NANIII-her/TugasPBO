package buatDatabase;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class UserInterface {

    public static void tampilkanMenu() {
        System.out.println("==================");
        System.out.println("| Pilih Menu:    |");
        System.out.println("------------------");
        System.out.println("| [C] : Create   |");
        System.out.println("| [R] : Read     |");
        System.out.println("| [U] : Update   |");
        System.out.println("| [D] : Delete   |");
        System.out.println("| [X] : Exit     |");
        System.out.println("==================");
    }

    public static void main(String[] args) {
        Database db = new Database();
        Scanner input = new Scanner(System.in);
        System.out.println(" APLIKASI SIMPLE CRUD TEXT DATABASE");

        while (true) {
            tampilkanMenu();
            System.out.print("Pilih : ");
            String pilih = input.next().toUpperCase();
            System.out.println();

            switch (pilih) {
                case "C":
                    System.out.println();
                    System.out.println("INFO: Anda memilih menu CREATE");
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("INPUT DATA BARU");
                    System.out.print("NIM            : ");
                    String nim = input.next();
                    input.nextLine();
                    System.out.print("NAMA MAHASISWA : ");
                    String nama = input.nextLine();
                    System.out.print("ALAMAT         : ");
                    String alamat = input.nextLine();
                    System.out.print("SEMESTER       : ");
                    int semester = input.nextInt();
                    System.out.print("SKS            : ");
                    int sks = input.nextInt();
                    System.out.print("IPK            : ");
                    double ipk = input.nextDouble();
                    input.nextLine();
                    System.out.println("----------------------------------------------------------------------------------");
                    boolean status = db.insert(nim, nama, alamat, semester, sks, ipk);

                    if (status == true) {
                        System.out.println("DATA BARU BERHASIL DITAMBAHKAN");
                    } else {
                        System.out.println("NIM " + nim + " sudah ada di dalam database");
                        System.err.println("GAGAL MENAMBAHKAN DATA BARU");
                    }

                    System.out.println("----------------------------------------------------------------------------------");
                    break;
                case "R":
                    System.out.println();
                    System.out.println("INFO: Anda memilih menu READ");
                    db.view();
                    break;
                case "U":
                    System.out.println("INFO: Anda memilih menu UPDATE");
                    db.view();
                    System.out.print("Input Key (NIM Mahasiswa yang akan diupdate): ");
                    String key = input.next();
                    int index = db.search(key);

                    if (index >= 0) {
                        System.out.println("Anda akan meng-update data " + db.getData().get(index));
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println("INPUT DATA BARU");
                        input.nextLine();
                        System.out.print("NIM            : ");
                        nim = input.nextLine();
                        System.out.print("NAMA MAHASISWA : ");
                        nama = input.nextLine();
                        System.out.print("ALAMAT         : ");
                        alamat = input.nextLine();
                        System.out.print("SEMESTER       : ");
                        semester = input.nextInt();
                        System.out.print("SKS            : ");
                        sks = input.nextInt();
                        System.out.print("IPK            : ");
                        ipk = input.nextDouble();
                        input.nextLine();
                        System.out.println("----------------------------------------------------------------------------------");

                        boolean status1 = db.insert(nim, nama, alamat, semester, sks, ipk);
                        if (status1 == true) {
                            status = db.update(index, nim, nama, alamat, semester, sks, ipk);
                            if (status == true) {
                                System.out.println("DATA BERHASIL DIPERBAHARUI");
                            } else {
                                System.err.println("GAGAL MEMPERBAHARUI DATA");
                                System.err.println("NIM " + nim + " sudah ada di dalam database");
                            }
                        } else {
                            System.out.println("NIM " + nim + " sudah ada di dalam database");
                            System.err.println("GAGAL MEMPERBAHARUI DATA");
                        }
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.println();
                    } else {
                        System.err.println("Mahasiswa dengan NIM: " + key + " tidak ada di dalam database");
                    }
                    break;
                case "D":
                    System.out.println("INFO: Anda memilih menu DELETE");
                    db.view();
                    System.out.print("Input Key (NIM Mahasiswa yang akan dihapus): ");
                    key = input.next();
                    index = db.search(key);

                    if (index >= 0) {
                        System.out.println("APAKAH ANDA YAKIN AKAN MENGHAPUS DATA " + db.getData().get(index) + "? Y/N");
                        System.out.print("Pilih : ");
                        pilih = input.next();

                        if (pilih.equalsIgnoreCase("Y")) {
                            status = db.delete(index);

                            if (status == true) {
                                System.out.println("DATA BERHASIL DIHAPUS");
                            } else {
                                System.err.println("GAGAL MENGHAPUS DATA");
                            }
                        }
                    } else {
                        System.err.println("Mahasiswa dengan NIM: " + key + " tidak ada di dalam database");
                    }
                    break;
                case "X":
                    System.out.println("INFO: Anda memilih menu EXIT");
                    System.out.println("APAKAH ANDA YAKIN INGIN KELUAR DARI APLIKASI? Y/N");
                    System.out.print("Pilih : ");
                    char ysn = input.next().toUpperCase().charAt(0);

                    if (ysn == 'Y') {
                        System.exit(0);
                    }

                    break;
            }
        }
    }
}
