
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        db.createTable();

        System.out.println("Hello my favorite user");

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
                    Librarian.showLibrary();
                }
                else if(act == 2){
                    Librarian.addBook(scan);
                    Librarian.showLibrary();
                }
                else if(act == 3){
                    Librarian.delBook(scan);
                    Librarian.showLibrary();
                }
                else if(act == 4){
                    Librarian.searchBook(scan);
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
                    System.out.println("Command not found!");
                }
            }

        }while(keepRunning);


    }

}

