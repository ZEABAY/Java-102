import java.util.Date;

public class Book implements Comparable<Book> {
    private String title;
    private int page;
    private String author;
    private Date publicationDate;


    public Book(String title, int page, String author, Date publicationDate) {
        this.title = title;
        this.page = page;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    @Override
    public int compareTo(Book otherBook) {
        return this.title.compareTo(otherBook.getTitle());
    }


    /////// getter setter ///////


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
