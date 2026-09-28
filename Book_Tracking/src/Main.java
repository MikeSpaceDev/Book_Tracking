import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello world");
        Book book1 = new Book("Metro 2033", "Dmitry Glukhovsky", "post-apocalypse", 2005);
        Book book2 = new Book("Metro 2034", "Dmitry Glukhovsky", "post-apocalypse", 2009);
        Book book3 = new Book("Metro 2035", "Dmitry Glukhovsky", "post-apocalypse", 2015);

        List<Book> listBooks = new ArrayList<>();
        listBooks.add(book1);
        listBooks.add(book2);
        listBooks.add(book3);

        boolean cont = false;

        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("What do you want to do? \n" +
                    "1 - view the library \n" +
                    "2 - add book in library\n" +
                    "3 - remove a book from the library\n" +
                    "4 - find a book");

            int act = Integer.parseInt(scan.nextLine());

            if(act == 1){
                showLibrary(listBooks);
            }
            else if(act == 2){
                addBook(scan, listBooks);
                showLibrary(listBooks);
            }
            else if(act == 3){
                System.out.println("Sorry? Function don't ready..");
            }
            else if(act == 4){
                System.out.println("Sorry? Function don't ready..");
            }

            System.out.println("Do you want continue?\n" +
                                "1 - yes\n" +
                                "other number - exit");
            act = Integer.parseInt(scan.nextLine());
            cont = (act == 1);
        }while(cont);


    }

    static void showLibrary(List<Book> lb){
        System.out.println("Hello, you have in your library:");
        System.out.println();
        for(Book bk: lb){
            System.out.println("Book title - " + bk.getName() + ", released in " + bk.getYear() + ". This book is " +
                                bk.getGenre() + ".");
            System.out.println("-----------------------------");
        }
    }

    static void addBook(Scanner scan, List<Book> lb){
        System.out.println("ADDING A BOOK:");
        System.out.println("-----------------------------");

        System.out.println("Enter the title:");
        String title = scan.nextLine();

        System.out.println("Enter the author:");
        String author = scan.nextLine();

        System.out.println("Enter the genre:");
        String genre = scan.nextLine();

        System.out.println("Enter the year:");
        int year = Integer.parseInt(scan.nextLine());

        lb.add(new Book(title, author, genre, year));

    }
}

