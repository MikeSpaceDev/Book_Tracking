import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseManager {
    private static final String url ="jdbc:sqlite:library.db";

    public void createTable(){
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt  = conn.createStatement()){
            System.out.println("Сonnection established");
            String createTableSql = """
                                    CREATE TABLE IF NOT EXISTS Books (
                                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                                    name TEXT,
                                    author TEXT,
                                    genre TEXT,
                                    year INTEGER )
                                    """;
            stmt.execute(createTableSql);
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }

    public void addBook(Book book){
        String addBookSQL = "INSERT INTO Books(name, author, genre, year) VALUES (?, ?, ?, ?)";
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt  = conn.prepareStatement(addBookSQL)){
            pstmt.setString(1, book.getName());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getGenre());
            pstmt.setInt(4, book.getYear());

            pstmt.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
