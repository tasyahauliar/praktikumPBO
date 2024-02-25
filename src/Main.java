import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Berikan Informasi Nama Kamu: ");
        String nama = scanner.nextLine();

        System.out.print("Berikan Informasi Jenis Kelamin kamu (P/L): ");
        char jenisKelamin = Character.toUpperCase(scanner.nextLine().charAt(0));
        String jenisKelaminString = (jenisKelamin == 'L') ? "Laki-laki" : "Perempuan";

        System.out.print("Berikan Informasi Tanggal Lahir Kamu (THN-BLN-TGL): ");
        String tanggalLahirString = scanner.nextLine();
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirString);

        LocalDate tanggalSekarang = LocalDate.now();
        Period period = Period.between(tanggalLahir, tanggalSekarang);
        int umurTahun = period.getYears();
        int umurBulan = period.getMonths();

        System.out.println("\n~~INFORMASI PERSONAL~~");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelaminString);
        System.out.println("Tanggal Lahir: " + tanggalLahir);
        System.out.println("Umur Kamu: " + umurTahun + " tahun " + umurBulan + " bulan");
    }
}