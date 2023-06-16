import java.util.*;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> bookSetByName = new TreeSet<>();
        bookSetByName.add(new Book("Book D", 300, "Author D", createDate(2020, 1, 1)));
        bookSetByName.add(new Book("Book A", 200, "Author A", createDate(2019, 1, 1)));
        bookSetByName.add(new Book("Book C", 150, "Author C", createDate(2022, 1, 1)));
        bookSetByName.add(new Book("Book B", 250, "Author B", createDate(2021, 1, 1)));
        bookSetByName.add(new Book("Book E", 400, "Author E", createDate(2023, 1, 1)));

        System.out.println("Kitaplar isme göre sıralandı:");
        for (Book book : bookSetByName) {
            System.out.println(book.getTitle());
        }


        TreeSet<Book> bookSetByPageCount = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPage() - o2.getPage();
            }
        });
        bookSetByPageCount.add(new Book("Book D", 300, "Author D", createDate(2020, 1, 1)));
        bookSetByPageCount.add(new Book("Book A", 200, "Author A", createDate(2019, 1, 1)));
        bookSetByPageCount.add(new Book("Book C", 150, "Author C", createDate(2022, 1, 1)));
        bookSetByPageCount.add(new Book("Book B", 250, "Author B", createDate(2021, 1, 1)));
        bookSetByPageCount.add(new Book("Book E", 400, "Author E", createDate(2023, 1, 1)));

        System.out.println("Kitaplar sayfa sayısına göre sıralandı:");
        for (Book book : bookSetByPageCount) {
            System.out.println(book.getTitle());
        }
    }

    private static Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }
}
