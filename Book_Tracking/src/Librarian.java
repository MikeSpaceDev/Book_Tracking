import java.util.List;
import java.util.Scanner;

public class Librarian {
    static Book searchBook(Scanner scan, List<Book> lb){
        System.out.println("Enter book title or part of the name");
        System.out.println();

        String title = scan.nextLine();


        for (Book bk: lb){
            if(bk.getName().contains(title)){
                return bk;
            }
        }
        return null;
    }

    static void delBook(Scanner scan, List<Book> lb){
        System.out.println("Which book do you want to delete ");
        System.out.println();

        String title = scan.nextLine();
        int index = -1;

        for (Book bk: lb){
            if(bk.getName().equals(title)){
                index = lb.indexOf(bk);
                break;
            }
        }

        if(index >= 0){
            lb.remove(index);
        }
        else{
            System.out.println("This book was not found...");
        }

    }

    static void showBook(Book bk){
        System.out.println("Here is your book:");
        System.out.println("--------------------------------");
        System.out.println(bk.getName() + " - " + bk.getAuthor() + " - " + bk.getGenre());
        System.out.println("--------------------------------");

    }

    static void showLibrary(List<Book> lb){
        System.out.println("You have in your library:");
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
