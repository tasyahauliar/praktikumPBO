import java.util.Scanner;

public class DemoPbo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data user admin
        String adminUsername = "admin";
        String adminPassword = "adm1n";

        // Data user mahasiswa
        String[] mahasiswaUsername = {"mahasiswa1", "mahasiswa2"};
        String[] mahasiswaPassword = {"202310370311248", "202310370311247"};

        // Login menu
        System.out.println("~~~SISTEM PERPUSTAKAAN~~~");
        System.out.println("Silakan pilih jenis login:");
        System.out.println("1. Masuk sebagai admin");
        System.out.println("2. Masuk sebagai mahasiswa");
        System.out.println("3. keluar");
        System.out.print("Ketikkan pilihan (1-3): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membuang karakter newline setelah nextInt()

        if (pilihan == 1) {
            // Login admin
            System.out.print("Username : ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (username.equals(adminUsername) && password.equals(adminPassword)) {
                System.out.println("Berhasil masuk sebagai admin");
                // Kode untuk akses fitur admin
            } else {
                System.out.println("Login gagal. Username atau password salah.");
            }
        } else if (pilihan == 2) {
            // Login sebagai mahasiswa
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            boolean loginSuccess = false;
            for (int i = 0; i < mahasiswaUsername.length; i++) {
                if (username.equals(mahasiswaUsername[i]) && password.equals(mahasiswaPassword[i])) {
                    loginSuccess = true;
                    break;
                }
            }

            if (loginSuccess) {
                System.out.println("Berhasil masuk sebagai mahasiswa");
                // Kode untuk akses fitur mahasiswa
            } else {
                System.out.println("Login gagal. Username atau password salah.");
            }
        } else {
            System.out.println("Selesai");
        }
    }
}