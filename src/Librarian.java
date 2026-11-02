import java.util.List;
import java.util.Scanner;

public class Librarian {

    private static DatabaseManager db = new DatabaseManager();

    static void searchBook(Scanner scan){
        System.out.println("Enter book title or part of the name");
        System.out.println();

        String title = scan.nextLine();

        List<Book> foundBooks = db.searchBook(title);

        if (foundBooks.isEmpty()){
            System.out.println("No matches found.");
        }
        else {
            System.out.println("Here is your book(s):");
            for (Book bk: foundBooks){
                showBook(bk);
            }
        }

    }

    static void delBook(Scanner scan){
        System.out.println("Which book do you want to delete ");
        System.out.println();

        String title = scan.nextLine();
        int index = -1;

        boolean del = db.delBook(title);

        if(!del){
            System.out.println("This book was not found...");
        }
        else{
            System.out.println("Deletion complete.");
        }

    }

    static void showBook(Book bk){
        System.out.println("--------------------------------");
        System.out.println(bk.getName() + " - " + bk.getAuthor() + " - " + bk.getGenre());
        System.out.println("--------------------------------");

    }

    static void showLibrary(){
        System.out.println("You have in your library:");
        List<Book> lb = db.getAllBooks();
        if(lb.isEmpty()){
            System.out.println("Library is Empty.");
        }
        else{
            System.out.println();
            for(Book bk: lb){
                System.out.println("Book title - " + bk.getName() + ", released in " + bk.getYear() + ". This book is " +
                        bk.getGenre() + ".");
                System.out.println("-----------------------------");
        }

        }
    }

    static void addBook(Scanner scan){
        System.out.println("ADDING A BOOK:");
        System.out.println("-----------------------------");

        System.out.println("Enter the title:");
        String title = scan.nextLine();

        System.out.println("Enter the author:");
        String author = scan.nextLine();

        System.out.println("Enter the genre:");
        String genre = scan.nextLine();

        int year;
        while(true){
            System.out.println("Enter the year:");
            try {
                year = Integer.parseInt(scan.nextLine());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Please enter a valid number for the year");
            }
        }


        db.addBook(new Book(title, author, genre, year));

    }

}
