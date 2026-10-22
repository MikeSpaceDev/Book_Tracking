import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionTest {
    public static void main(String[] args) {
        final String url = "jdbc:sqlite:test.db";
        try(Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()){
                System.out.println("All good");
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

}
