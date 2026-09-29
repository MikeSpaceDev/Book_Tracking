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
                Librarian.showLibrary(listBooks);
            }
            else if(act == 2){
                Librarian.addBook(scan, listBooks);
                Librarian.showLibrary(listBooks);
            }
            else if(act == 3){
                Librarian.delBook(scan, listBooks);
                Librarian.showLibrary(listBooks);
            }
            else if(act == 4){
                Book bk = Librarian.searchBook(scan, listBooks);
                if(bk != null){
                    Librarian.showBook(bk);
                }
                else{
                    System.out.println("No matches found.");
                }
            }

            System.out.println("Do you want continue?\n" +
                                "1 - yes\n" +
                                "other number - exit");
            act = Integer.parseInt(scan.nextLine());
            cont = (act == 1);
        }while(cont);


    }



}

