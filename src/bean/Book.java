package bean;

public class Book {
    private int id;
    private String name;
    private int price;
    private int pageCount;
    private String isbn;
    private String genre;
    private String author;
    private int year;
    private String publisher;
    private int imageNumber;

    public Book() {
    }

    public Book(int id, String name, int price, int pageCount, String isbn, String genre, String author, int year, String publisher, int imageNumber) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.imageNumber = imageNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getImageNumber() {
        return imageNumber;
    }
}
