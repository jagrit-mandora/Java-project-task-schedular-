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

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");

    input_helper helper = new input_helper();

    Scanner sc = new Scanner(System.in);

    public void addtaskinput(){

        String title = helper.readtitle();
        System.err.println("Your title: " + title);

        System.out.print("please enter the description: ");
        String description = sc.nextLine();
        System.out.println("Your description is : " + description);

        Priority priority = Priority.valueOf(helper.readpriority());
        System.out.println("Your priority is : " + priority);

        Category category = Category.valueOf(helper.readCategory());
        System.out.println("Your category is : " + category);

        System.out.print("please enter the deadline in format of (dd-mm-yyyy hh-mm): ");
        String deadline_sc=sc.nextLine();
        LocalDateTime deadline = LocalDateTime.parse(deadline_sc, formatter);

        System.out.print("please enter the estimated duration of task in hours: ");
        int hours= Integer.parseInt(sc.nextLine());
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

    public void view_task(){
        System.err.println("Please enter the id of task you want to view: ");
        int id = Integer.parseInt(sc.nextLine());
        for (int i=0; i < task.size() ; i++){
            Taskfile t = task.get(i);
            if ( t.gettask_id().equals(String.valueOf(id)) ){
                System.err.println(t.tostring());
            }
        }
    }

    public void removetask() {
        System.err.print("Please enter the id of task you want to remove: ");
        int id = Integer.parseInt(sc.nextLine());
        for (int i=0; i < task.size() ; i++){
            Taskfile t = task.get(i);
            if ( t.gettask_id().equals(String.valueOf(id)) ){
                task.remove(i);
                System.err.println(t.tostring());
            }
        }
    }

    public void showtask(){
        for (int i=0; i < task.size() ; i++){
            Taskfile t = task.get(i);
            System.err.println(t.tostring());
            }
        }

    public void edittask(){
        boolean running = true;
        System.err.print("Please enter the id of task you want to change: ");
        int id = Integer.parseInt(sc.nextLine());
        for (int i=0; i < task.size() ; i++){
            Taskfile t = task.get(i);
            if ( t.gettask_id().equals(String.valueOf(id)) ){
                System.err.println(t.toString());

                while (running) { 
                    System.out.println("1. Title");
                    System.out.println("2. description");
                    System.out.println("3. Priority");
                    System.out.println("4. Category");
                    System.out.println("5. Deadline");
                    System.out.println("6. Estimated time");
                    System.out.println("7. Status");
                    System.out.println("8. Cancel");
                    System.out.print("Choose a option: ");

                    int choice = Integer.parseInt(sc.nextLine());

                    if (choice == 1) {
                        System.err.print("Please enter the title you want to change to: ");
                        String newtitle = sc.nextLine();
                        t.settitle(newtitle);
                        showtask();
                    } else if (choice == 2){            
                        System.err.print("Please enter the description you want to change to: ");
                        String newdescription = sc.nextLine();
                        t.setdescription(newdescription);
                        showtask();
                    } else if (choice == 3){            
                        System.err.print("Please enter the Priority (LOW , MEDIUM, HIGH, URGENT) you want to change to: ");
                        String newpriority = sc.nextLine();
                        Priority priority = Priority.valueOf(newpriority.toUpperCase());
                        t.setpriority(priority);
                        showtask();
                    } else if (choice == 4){            
                        System.err.print("Please enter the Status (WORK, STUDY, EXPENSES, OTHERS) you want to change to: ");
                        String newcategory = sc.nextLine();
                        Category category = Category.valueOf(newcategory.toUpperCase());
                        t.setcategory(category);
                        showtask();
                    }  else if (choice == 5){            
                        System.err.print("Please enter the Deadline you want to change to: ");
                        String deadline_sc = sc.nextLine();
                        LocalDateTime deadline = LocalDateTime.parse(deadline_sc, formatter);
                        t.setdeadline(deadline);
                        showtask();
                    } else if (choice == 6){            
                        System.err.print("Please enter the Estimated time you want to change to: ");
                        int hours= Integer.parseInt(sc.nextLine());
                        Duration estimated_time = Duration.ofHours(hours);
                        t.setestimated_time(estimated_time);
                        showtask();
                    } else if (choice == 7){            
                        System.out.print("please enter the Status to change to (TODO, DOING, DONE, OVERDUE): ");
                        String status_sc = sc.nextLine();
                        Status status = Status.valueOf(status_sc.toUpperCase());
                        t.setstatus(status);
                        if (status == Status.DONE){
                            t.setcompletion_date(LocalDateTime.now());
                            System.out.println("DEBUG: " + t.getcompletion_date());
                        showtask();
                    } else if (choice == 8){
                        running = false;
                    } else {showtask();}
        
                }

            }
        }
    }
}
}