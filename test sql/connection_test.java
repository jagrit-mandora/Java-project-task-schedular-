import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connection_test{
    public static void main(String[] args) {
        try(Connection c = DriverManager.getConnection("jdbc:sqlite:task.db")){
            String st1 = "CREATE TABLE IF NOT EXISTS TASKS (TITLE, CATEGORY, STATUS)";
            c.createStatement().execute(st1);
            String sql = "INSERT INTO TASKS (TITLE, CATEGORY, STATUS) VALUES(?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, "a");
            ps.setString(2, "b");
            ps.setString(3, "c");
            ps.executeUpdate();

            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM TASKS");
            while(rs.next()){
                String Category = rs.getString("Category");
                String title = rs.getString("title");
                System.err.println(Category + "--" + title);
            }
            
            System.err.println("connection successfull");
        } catch(SQLException e){
            System.err.println("error: " + e.getMessage());
        }
    }
}