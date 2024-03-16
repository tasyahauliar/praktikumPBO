import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    String nim;
    String nama;
    String programStudi;

    public Student(String nim, String nama, String programStudi) {
        this.nim = nim;
        this.nama = nama;
        this.programStudi = programStudi;
    }
}

class Book {
    String id;
    String judul;
    String pengarang;
    String kategori;
    int stok;

    public Book(String id, String judul, String pengarang, String kategori, int stok) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.kategori = kategori;
        this.stok = stok;
    }
}

public class LibrarySystem {

    private static List<Student> mahasiswa = new ArrayList<>();
    private static List<Book> buku = new ArrayList<>();

    public static void main(String[] args) {
        buku.add(new Book("001", "Indonesia Emas", "liliam", "Sejarah", 4));
        buku.add(new Book("002", "pahlawan Bangsa", "Budi", "Sejarah", 2));
        buku.add(new Book("003", "Patriot Bangsa", "Eko", "Sejarah", 1));

        mahasiswa.add(new Student("202210370311248", "Tasyah Aulia Rahma", "Informatika"));
        mahasiswa.add(new Student("202210370311998", "kikiy Amelia Cika", "Informatika"));
        mahasiswa.add(new Student("202210370311999", "Putri permatasari", "Informatika"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Sistem Perpustakaan =====");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    loginSebagaiMahasiswa(scanner);
                    break;
                case 2:
                    loginSebagaiAdmin(scanner);
                    break;
                case 3:
                    System.out.println("Terima kasih. Keluar dari program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }

    private static void loginSebagaiMahasiswa(Scanner scanner) {
        System.out.print("\nMasukkan NIM Anda (input 99 untuk kembali): ");
        String nim = scanner.next();

        if (!nim.equals("99")) {
            System.out.println("====Menu Mahasiswa====");
            System.out.println("1. Buku yang Dipinjam");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Fitur Buku yang Dipinjam belum diimplementasikan.");
                    break;
                case 2:
                    pinjamBuku(nim, scanner);
                    break;
                case 3:
                    System.out.println("Keluar dari akun mahasiswa.");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }

    private static void loginSebagaiAdmin(Scanner scanner) {
        System.out.println("\nMenu Admin");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Tampilkan Mahasiswa Terdaftar");
        System.out.println("3. Logout");
        System.out.print("Pilih opsi (1-3): ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                System.out.println("Fitur Tambah Mahasiswa belum diimplementasikan.");
                break;
            case 2:
                tampilkanMahasiswaTerdaftar();
                break;
            case 3:
                System.out.println("Keluar dari akun admin.");
                break;
            default:
                System.out.println("Opsi tidak valid. Silakan coba lagi.");
                break;
        }
    }

    private static void pinjamBuku(String nim, Scanner scanner) {
        System.out.println("\nNo. Id Buku || Stok || Judul || Pengarang || Kategori");
        for (Book buku : buku) {
            System.out.printf("%-5s || %-5d || %-10s || %-10s || %-10s%n", buku.id, buku.stok, buku.judul, buku.pengarang, buku.kategori);
        }

        System.out.print("\nMasukkan Id Buku yang ingin dipinjam (input 99 untuk kembali): ");
        String id = scanner.next();

        if (!id.equals("99")) {
            Book bukuDipinjam = buku.stream().filter(b -> b.id.equals(id)).findFirst().orElse(null);

            if (bukuDipinjam == null || bukuDipinjam.stok == 0) {
                System.out.println("Buku tidak tersedia atau sudah dipinjam.");
                return;
            }

            bukuDipinjam.stok--;
            System.out.printf("Buku %s (%s) berhasil dipinjam.", bukuDipinjam.judul, bukuDipinjam.pengarang);
        }
    }

    private static void tampilkanMahasiswaTerdaftar() {
        System.out.println("\nNama\t\tNIM\t\tProgram Studi");
        for (Student mahasiswa : mahasiswa) {
            System.out.printf("%s\t\t%s\t\t%s%n", mahasiswa.nama, mahasiswa.nim, mahasiswa.programStudi);
        }
    }
}
