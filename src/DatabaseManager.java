import java.sql.Connection;
import java.sql.DriverManager;
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


}
