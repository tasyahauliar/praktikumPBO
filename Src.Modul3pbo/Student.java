class Student extends User {
    private Book[] borrowedBooks;
    private int borrowedCount;

    public Student(String name, String nim, String faculty, String programStudi) {
        super(name, nim, faculty, programStudi);
        borrowedBooks = new Book[10];
        borrowedCount = 0;
    }

    @Override
    public void showBorrowedBooks() {
        System.out.println("Buku yang dipinjam:");
        for (Book book : borrowedBooks) {
            if (book != null) {
                System.out.println("ID: " + book.bookId + " | Judul: " + book.title + " | Penulis: " + book.author);
            }
        }
    }

    public void borrowBook(Book book) {
        if (borrowedCount < borrowedBooks.length && book.stock > 0) {
            borrowedBooks[borrowedCount++] = book;
            book.stock--;
            System.out.println("Buku dengan ID " + book.bookId + " berhasil dipinjam.");
        } else {
            System.out.println("Maaf, tidak dapat meminjam buku.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedCount > 0) {
            for (int i = 0; i < borrowedBooks.length; i++) {
                if (borrowedBooks[i] != null && borrowedBooks[i].bookId.equals(book.bookId)) {
                    borrowedBooks[i] = null;
                    borrowedCount--;
                    book.stock++;
                    System.out.println("Buku dengan ID " + book.bookId + " berhasil dikembalikan.");
                    return;
                }
            }
            System.out.println("Buku tidak ditemukan dalam daftar peminjaman.");
        } else {
            System.out.println("Tidak ada buku yang dipinjam.");
        }
    }

    @Override
    public void displayBooks(Book[] books) {
        super.displayBooks(books);
    }
}

