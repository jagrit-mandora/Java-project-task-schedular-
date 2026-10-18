import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class input_helper{

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm");

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
        LocalDateTime validation;
        LocalDateTime validation_go;
        while(true){
            System.out.print("please enter the deadline in format of (dd-mm-yyyy hh-mm): ");
            String deadline = sc.nextLine();
            try {
                validation = LocalDateTime.parse(deadline, formatter);
                validation_go = validation;
                return validation_go;
            } catch (DateTimeParseException e) {
                System.err.println("please enter right date.");
            }
        }
        
    }

    public Duration readduration(){
        int validation;
        while(true){
            System.out.print("please enter the estimated duration of task in hours: ");
            String hours= sc.nextLine();
            try{
                validation = Integer.parseInt(hours);
                Duration estimated_time = Duration.ofHours(validation);
                return estimated_time;
            } catch(NumberFormatException e){
                System.err.println("Enter the right duration.");
            }
        }
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