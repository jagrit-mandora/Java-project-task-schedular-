import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

//Arraylist = ArrayList in Java is a resizable 
//array provided in the java.util package. Unlike normal arrays, its size can grow or shrink dynamically as elements are 
//added or removed.
 
public class Taskmanager{
    
    private ArrayList<Taskfile> task = new ArrayList<>();

    public void addtaskinput() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");

        Scanner taskinput = new Scanner(System.in);

        System.out.print("please enter the title: ");
        String title = taskinput.nextLine();
        System.out.println("Your title is : " + title);

        System.out.print("please enter the description: ");
        String description = taskinput.nextLine();
        System.out.println("Your description is : " + description);

        System.out.print("please enter the priority (LOW , MEDIUM, HIGH, URGENT): ");
        String priority_input = taskinput.nextLine();
        Priority priority = Priority.valueOf(priority_input.toUpperCase());
        System.out.println("Your priority is : " + priority);

        System.out.print("please enter the category (WORK, STUDY, EXPENSES, OTHERS): ");
        String category_input = taskinput.nextLine();
        Category category = Category.valueOf(category_input.toUpperCase());
        System.out.println("Your category is : " + category);

        System.out.print("please enter the deadline in format of (dd-mm-yyyy hh-mm): ");
        String deadline_input=taskinput.nextLine();
        LocalDateTime deadline = LocalDateTime.parse(deadline_input, formatter);

        System.out.print("please enter the estimated duration of task in hours: ");
        int hours= taskinput.nextInt();
        Duration estimated_time = Duration.ofHours(hours);

        Taskfile t1= new  Taskfile(
        title,
        description,
        priority,
        category,
        deadline,
        estimated_time);

        task.add(t1);

        System.err.println(t1.tostring());
        }

        public void removetask() {
            task.remove(0);
        }

        public void showtask(){
            for (int i=0; i < task.size() ; i++){
                Taskfile t = task.get(i);
                System.err.println(t.tostring());
                }
            }

        public void edittask(){
            Scanner idinput = new Scanner(System.in);
            System.err.print("Please enter the id of task you want to change: ");
            int id = idinput.nextInt();
            for (int i=0; i < task.size() ; i++){
                Taskfile t = task.get(i);
                if ( t.gettask_id().equals(String.valueOf(id)) ){
                    System.err.println(t.toString());
                    Scanner estimated_time_input = new Scanner(System.in);
                    System.err.print("Please enter the estimated time you want to change to: ");
                    int hours= estimated_time_input.nextInt();
                    Duration estimated_time = Duration.ofHours(hours);
                    t.setestimated_time(estimated_time);
                }

            }
        }

}