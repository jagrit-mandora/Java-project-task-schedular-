import java.time.Duration;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner taskinput = new Scanner(System.in);
        boolean running = true;
        Taskdatabase database = new Taskdatabase();
        database.intialize();
        Taskmanager manager = new Taskmanager();        
        
        while (running){
            System.out.println("0. suggest task");
            System.out.println("1. add task");
            System.out.println("2. view task");
            System.out.println("3. show all");
            System.out.println("4. edit task ");
            System.out.println("5. remove task ");
            System.out.println("6. exit ");
            System.out.print("Choose a option: ");

            int choice = Integer.parseInt(taskinput.nextLine());

            if (choice==0) {
                int validation;
                boolean going = true;
                while(going){
                    System.out.print("please enter the estimated free minutes of task: ");
                    String minutes= taskinput.nextLine();
                    try{
                        validation = Integer.parseInt(minutes);
                        Duration estimated_time = Duration.ofMinutes(validation);
                        manager.suggesttask(estimated_time.toMinutes());
                        going = false;
                    } catch(NumberFormatException e){
                        System.err.println("Enter the right duration.");
                    }
                }
            } else if (choice==1) {
                manager.addtaskinput();
            } else if (choice==2) {
                manager.view_task();
            } else if (choice==3) {
                manager.showtask();   
            } else if (choice==4) {
               manager.edittask();
            } else if (choice==5){   
                manager.removetask(); 
            } else if (choice==6){   
                running=false; 
            } else {
                System.out.println("INVALID CHOICE PLEASE ENTER AGAIN: ");
            }

        }
        System.out.println("Program finished...");

    }
}