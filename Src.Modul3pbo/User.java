public class User {
    protected String name;
    protected String nim;
    protected String faculty;
    protected String programStudi;

    public User(String name, String nim, String faculty, String programStudi) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.programStudi = programStudi;
    }

    public void displayInfo() {
        System.out.println("Nama: " + name);
        System.out.println("NIM: " + nim);
        System.out.println("Fakultas: " + faculty);
        System.out.println("Program Studi: " + programStudi);
    }

    public void showBorrowedBooks() {
    }

    public void logout() {
    }

    public void displayBooks(Book[] books) {
        System.out.println("Daftar Buku:");
        for (Book book : books) {
            System.out.println("ID: " + book.bookId + " | Judul: " + book.title + " | Penulis: " + book.author);
        }
    }
}
