import java.util.ArrayList;
import java.util.List;

public class Main{
    static void main(String[] args) {
        System.out.println("Hello world");
        Book book1 = new Book("Metro 2033", "Dmitry Glukhovsky", "post-apocalypse", 2005);
        Book book2 = new Book("Metro 2034", "Dmitry Glukhovsky", "post-apocalypse", 2009);
        Book book3 = new Book("Metro 2035", "Dmitry Glukhovsky", "post-apocalypse", 2015);

        List<Book> listBooks = new ArrayList<>();
        listBooks.add(book1);
        listBooks.add(book2);
        listBooks.add(book3);

        System.out.println("Hello, you have in your library:");
        System.out.println();
        for(Book bk: listBooks){
            System.out.println("Book title - " + bk.getName() + ", released in " + bk.getYear());
            System.out.println("-----------------------------");
        }

    }
}

