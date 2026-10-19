
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class connection_test{
    public static void main(String[] args) {
        try(Connection c = DriverManager.getConnection("jdbc:sqlite:task.db")){
            System.err.println("connection successfull");
        } catch(SQLExeption e){
            System.err.println("error: " + e.getmessage);
        }
    }
}