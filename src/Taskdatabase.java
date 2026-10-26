import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Taskdatabase{
    
    public void intialize(){
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:task.db")){
            String s1 = "CREATE TABLE IF NOT EXISTS TASKS (TASK_ID INTEGER PRIMARY KEY AUTOINCREMENT," + 
            "TITLE VARCHAR(225) NOT NULL,DESCRIPTION," + 
            " PRIORITY,CATEGORY,CREATION_DATE,DEADLINE,COMPLETION_DATE,ESTIMATED_TIME,STATUS)";
            c.createStatement().execute(s1);
        } catch (SQLException e) {
            System.err.println("SQL ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void inserttask(Taskfile t){
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:task.db")){
            String sql = "INSERT INTO TASKS (TITLE,DESCRIPTION," + 
            "PRIORITY,CATEGORY,CREATION_DATE,DEADLINE,COMPLETION_DATE,ESTIMATED_TIME,STATUS)" + 
            "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.gettilte());
            ps.setString(2, t.getdescription());
            ps.setString(3, t.getpriority().name());
            ps.setString(4, t.getcategory().name());
            ps.setString(5, t.getcreation_date().toString());
            ps.setString(6, t.getdeadline().toString());
            if(t.getcompletion_date() == null){
                ps.setNull(7, java.sql.Types.VARCHAR);
            }
            else{
                ps.setString(7, t.getcompletion_date().toString());
            }
            ps.setLong(8, t.getestimated_time().toMinutes());
            ps.setString(9, t.getstatus().name());
            ps.executeUpdate();

            ResultSet key = ps.getGeneratedKeys();
            if(key.next()){
                int newid = key.getInt(1);
                t.settask_id(newid);
            }

        } catch (SQLException e){
            System.err.println("SQL ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<Taskfile> getalltask(){
        ArrayList<Taskfile> task = new ArrayList<>();
        try(Connection c = DriverManager.getConnection("jdbc:sqlite:task.db")) {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM TASKS");
            while(rs.next()){
                int task_id = rs.getInt("TASK_ID");
                String title = rs.getString("TITLE");
                String description = rs.getString("DESCRIPTION");
                Priority priority = Priority.valueOf(rs.getString("PRIORITY"));
                Category category = Category.valueOf(rs.getString("CATEGORY"));
                LocalDate creation_date = LocalDate.parse(rs.getString("CREATION_DATE"));
                LocalDateTime deadline = LocalDateTime.parse(rs.getString("DEADLINE"));
                String completionText = rs.getString("COMPLETION_DATE");
                LocalDateTime completion_date = null;
                if (completionText != null) {
                    completion_date = LocalDateTime.parse(completionText);
                }
                Duration estimated_time = Duration.ofMinutes(rs.getLong("ESTIMATED_TIME"));
                Status status = Status.valueOf(rs.getString("STATUS"));

                Taskfile t = new Taskfile (task_id,title,description,priority,category,creation_date,
                deadline,completion_date,estimated_time,status);

                task.add(t);      
            }
        } catch (SQLException e) {
            System.err.println("SQL ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        return task;
    }
}