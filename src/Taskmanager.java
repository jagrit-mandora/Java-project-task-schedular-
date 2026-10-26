import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

//Arraylist = ArrayList in Java is a resizable 
//array provided in the java.util package. Unlike normal arrays, its size can grow or shrink dynamically as elements are 
//added or removed.
 
public class Taskmanager{
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");

    input_helper helper = new input_helper();

    Taskdatabase database = new Taskdatabase();

    ArrayList<Taskfile> task = database.getalltask();

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

        LocalDateTime deadline = helper.readdeadline();
        System.err.println("Your deadline is : " + deadline);
        
        Duration estimated_time = helper.readduration();
        System.err.println("Your Duration is : " + estimated_time);

        Taskfile t1 = new  Taskfile(
        title,
        description,
        priority,
        category,
        deadline,
        estimated_time);

        task.add(t1);

        database.inserttask(t1);

        System.err.println(t1.tostring());
        }

    public void view_task(){
        System.err.println("Please enter the id of task you want to view: ");
        int id = Integer.parseInt(sc.nextLine());
        for (int i=0; i < task.size() ; i++){
            Taskfile t = task.get(i);
            if ( t.gettask_id()==id){
                System.err.println(t.tostring());
            }
        }
    }

    public void removetask() {
        System.err.print("Please enter the id of task you want to remove: ");
        int id = Integer.parseInt(sc.nextLine());
        for (int i=0; i < task.size() ; i++){
            Taskfile t = task.get(i);
            if ( t.gettask_id()==id){
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
            if ( t.gettask_id()==id){
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
                        String newtitle = helper.readtitle();
                        t.settitle(newtitle);
                        showtask();
                    } else if (choice == 2){            
                        System.err.print("Please enter the description you want to change to: ");
                        String newdescription = sc.nextLine();
                        t.setdescription(newdescription);
                        showtask();
                    } else if (choice == 3){            
                        Priority priority = Priority.valueOf(helper.readpriority());
                        t.setpriority(priority);
                        showtask();
                    } else if (choice == 4){            
                        Category category = Category.valueOf(helper.readCategory());
                        t.setcategory(category);
                        showtask();
                    }  else if (choice == 5){            
                        LocalDateTime deadline = helper.readdeadline();
                        t.setdeadline(deadline);
                        showtask();
                    } else if (choice == 6){            
                        Duration estimated_time = helper.readduration();
                        t.setestimated_time(estimated_time);
                        showtask();
                    } else if (choice == 7){            
                        Status status = Status.valueOf(helper.readStatus());
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