package bean;

import java.awt.*;

public class Book {
    private String name;
    private byte[] content;
    private int pageCount;
    private String isbn;
    private int genreId;
    private int authorId;
    private int year;
    private int publisherId;
    private Image image;

    public Book() {
    }

    public Book(String name, int pageCount, String isbn, int genreId, int authorId, int year, int publisherId) {
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genreId = genreId;
        this.authorId = authorId;
        this.year = year;
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
