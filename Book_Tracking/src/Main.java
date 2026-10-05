import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello my favorite user");

        List<Book> listBooks = new ArrayList<>();

        File file = new File("All books");

        FileManager.readFile(listBooks);


        boolean cont = false;

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
                    cont = true;
                }

                System.out.println("Do you want continue?\n" +
                        "1 - yes\n" +
                        "other number - exit");
                act = Integer.parseInt(scan.nextLine());
                cont = (act == 1);

            }catch(NumberFormatException e) {
                System.out.println("Сommand not found!");
                cont = true;
            }

        }while(cont);

        FileManager.wrideInFile(listBooks);


    }

}

