class Book {
    protected String bookId;
    protected String title;
    protected String author;
    protected String category;
    protected int stock;
    protected int duration;

    public Book(String bookId, String title, String author, String category, int stock, int duration) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
        this.duration = duration;
    }
}
