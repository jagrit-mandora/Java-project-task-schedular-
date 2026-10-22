import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Taskdatabase{
    
    public void intialize(){
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:task.db")){
            String s1 = "CREATE TABLE IF NOT EXIST TASKS (TASK_ID, TITLE, DESCRIPTION," + 
            " PRIORITY, CATEGORY, CREATION DATE, DEADLINE, COMPLITION DATE, ESTIMATED TIME, STATUS)";
            c.createStatement().execute(s1);
        } catch (SQLException e) {
            System.err.println("ERROR WITH DATABASE");
        }
    }
}