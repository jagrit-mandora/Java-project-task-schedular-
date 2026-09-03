import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner taskinput = new Scanner(System.in);
        boolean running = true;

        while (running){
            System.out.println("1. add task");
            System.out.println("2. view task");
            System.out.println("3. exit");
            System.out.println("4. show all");
            System.out.print("Choose a option: ");

            int choice = taskinput.nextInt();

            if (choice==1) {
                Taskmanager manager = new Taskmanager();
                manager.addtaskinput();
            } else if (choice==2) {
                System.err.println("j");
            } else if (choice==3) {   
                running=false;
            } else if (choice==4) {
                Taskmanger managerdisplay = new Taskmanager();
                managerdisplay.showtask();
            }else {
                System.out.println("INVALID CHOICE PLEASE ENTER AGAIN: ");
            }

        }
        System.out.println("Program finished...");

    }
}