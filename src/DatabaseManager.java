import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String url ="jdbc:sqlite:library.db";

    public void createTable(){
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt  = conn.createStatement()){
            System.out.println("Connection established");
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

    public List<Book> searchBook(String title){

        List<Book> foundBooks = new ArrayList<>();
        String searchBookSQL = "SELECT * FROM Books WHERE name LIKE ?";
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt  = conn.prepareStatement(searchBookSQL)){
            pstmt.setString(1, "%" + title + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Book book = new Book(
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getInt("year"),
                        rs.getInt("id")
                        );
                foundBooks.add(book);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return foundBooks;
    }

    public boolean delBook(String title){
        int colDelBooks = 0;
        String searchBookSQL = "DELETE FROM Books WHERE name = ?";
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt  = conn.prepareStatement(searchBookSQL)){
            pstmt.setString(1, title);
            colDelBooks = pstmt.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return colDelBooks > 0;
    }

    public List<Book> getAllBooks(){
        List<Book> library = new ArrayList<>();
        String showAllBooksSQL = "SELECT * FROM Books";
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt  = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(showAllBooksSQL);

            while (rs.next()){
                Book book = new Book(
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getInt("year"),
                        rs.getInt("id")
                );
                library.add(book);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return library;
    }


}
