import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.format.DateTimeFormatter;

private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");

public class input_helper{

    Scanner sc = new Scanner(System.in);

    public String readtitle(){
        System.out.print("please enter the title: ");
        String title = sc.nextLine();
        while(title.trim().isEmpty()){
            System.out.print("please enter the title: ");
            title = sc.nextLine();
        }
        String validation_go = title;
        return validation_go;
    }

    public String readpriority(){
        System.out.print("please enter the priority (LOW , MEDIUM, HIGH, URGENT): ");
        String validation = sc.nextLine().toUpperCase();
        while(!List.of("LOW" , "MEDIUM", "HIGH", "URGENT").contains(validation)){
            System.out.print("please enter the priority (LOW , MEDIUM, HIGH, URGENT): ");
            validation = sc.nextLine().toUpperCase();
        }
        String validation_go = validation;
        return validation_go;
    }

    public String readCategory(){
        System.out.print("please enter the category (WORK, STUDY, EXPENSES, OTHERS): ");
        String validation = sc.nextLine().toUpperCase();
        while(!List.of("WORK", "STUDY", "EXPENSES", "OTHERS").contains(validation)){
            System.out.print("please enter the Category (WORK, STUDY, EXPENSES, OTHERS): ");
            validation = sc.nextLine().toUpperCase();
        }
        String validation_go = validation;
        return validation_go;
    }

    public LocalDateTime readdeadline(){
        while(true){
            System.out.print("please enter the deadline in format of (dd-mm-yyyy hh-mm): ");
            String deadline = sc.nextLine();
            try {
                LocalDateTime validation = LocalDateTime.parse(deadline, formatter);
            } catch (DateTimeParseException e) {
                System.err.println("please enter right date.");
                continue;
            }
        }
        LocalDateTime validation_go = validation;
        return validation_go;
    }

    public String readStatus(){
        System.out.print("please enter the category : (TODO, DOING, DONE, OVERDUE)");
        String validation = sc.nextLine().toUpperCase();
        while(!List.of("TODO", "DOING", "DONE", "OVERDUE").contains(validation)){
            System.out.print("please enter the Category (TODO, DOING, DONE, OVERDUE): ");
            validation = sc.nextLine().toUpperCase();
        }
        String validation_go = validation;
        return validation_go;
    }
}