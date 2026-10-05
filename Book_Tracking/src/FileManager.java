import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    static File file = new File("All books");

    static void readFile(List<Book> lb){
        try (Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String[] strArr = scanner.nextLine().split("\\|");
                lb.add(new Book(strArr[0], strArr[1], strArr[2], Integer.parseInt(strArr[3])));

            }
        } catch (
                FileNotFoundException e) {
            System.out.println("Something went wrong with the disk. " + e.getMessage());
        }
    }

    static void wrideInFile(List<Book> lb){
        try (PrintWriter pw = new PrintWriter(file)){
            for (Book bk: lb){
                pw.println(bk.getName() + "|" + bk.getAuthor() + "|" + bk.getGenre() + "|" + bk.getYear());
            }
            System.out.println("Files successfully written.");
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong with the disk. " + e.getMessage());
        }
    }


}
