import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello my favorite user");

        DatabaseManager db = new DatabaseManager();
        db.createTable();

        List<Book> listBooks = new ArrayList<>();


        FileManager.readFile(listBooks);


        boolean keepRunning = false;
        boolean askAgain = true;

        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("What do you want to do? \n" +
                    "1 - view the library \n" +
                    "2 - add book in library\n" +
                    "3 - remove a book from the library\n" +
                    "4 - find a book\n" +
                    "5 - exit");


            try{
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

                else if (act == 5) {
                    break;
                } else{
                    System.out.println("Сommand not found!");
                    keepRunning = true;
                }


            }catch(NumberFormatException e) {
                System.out.println("Сommand not found!");
                keepRunning = true;
            }

            while(askAgain){
                try {
                    System.out.println("Do you want continue?\n" +
                            "1 - yes\n" +
                            "other number - exit");
                    int actIn = Integer.parseInt(scan.nextLine());
                    askAgain = false;
                    keepRunning = (actIn == 1);
                }
                catch (NumberFormatException e){
                    System.out.println("Сommand not found!");
                }
            }

        }while(keepRunning  );

        FileManager.writeInFile(listBooks);

    }

}

