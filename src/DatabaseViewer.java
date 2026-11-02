import java.sql.*;

public class DatabaseViewer {
    public static void main(String[] args) {
          final String url ="jdbc:sqlite:library.db";

//        DatabaseManager db = new DatabaseManager();
//        List<Book> libriary = new ArrayList<>();
//        FileManager.readFile(libriary);
//
//        for(Book bk: libriary){
//            db.addBook(bk);
//        }

        final String sql = "SELECT * FROM Books";
        try(Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()){
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    System.out.println(
                            rs.getInt("id") + " | " + rs.getString("name") + " | " +
                            rs.getString("author") + " | " + rs.getString("genre") + " | " +
                            rs.getInt("year"));
                }
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

}
