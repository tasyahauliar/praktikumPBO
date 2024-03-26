class Admin extends User {
    private Book[] bookList;
    private int bookCount;

    public Admin(String name, String nim, String faculty, String programStudi) {
        super(name, nim, faculty, programStudi);
        bookList = new Book[100];
        bookCount = 0;
    }

    public void addBook(String title, String author, String category, int stock, int duration) {
        String bookId = generateId();
        Book book = null;
        if (category.equalsIgnoreCase("history")) {
            book = new HistoryBook(bookId, title, author, category, stock, duration);
        } else if (category.equalsIgnoreCase("story")) {
            book = new StoryBook(bookId, title, author, category, stock,
                    duration);
        } else if (category.equalsIgnoreCase("text")) {
            book = new TextBook(bookId, title, author, category, stock, duration);
        }
        if (book != null && bookCount < bookList.length) {
            bookList[bookCount++] = book;
            System.out.println("Buku dengan ID " + bookId + " berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan buku.");
        }
    }

    public void modifyBook(String bookId, int stock) {
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].bookId.equals(bookId)) {
                bookList[i].stock = stock;
                System.out.println("Stok buku dengan ID " + bookId + " berhasil diubah.");
                return;
            }
        }
        System.out.println("Buku dengan ID " + bookId + " tidak ditemukan.");
    }

    @Override
    public void displayBooks(Book[] books) {
        super.displayBooks(books);
    }

    private String generateId() {
        // Implementasi untuk generate ID unik
        return "B" + (bookCount + 1);
    }
}
