import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

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

    /*Taskfile t1= new  Taskfile(
        "1",
        "testing", 
        "to check if this works",
        Priority.URGENT, 
        Category.WORK,
        LocalDateTime.of(2026, 04, 16, 15, 13), 
        Duration.ofHours(4));*/

    System.err.println(t1.tostring());

   /*System.out.println(
        t1.gettask_id() + " ," + 
        t1.gettilte() + " ," + 
        t1.getdescription()+" ,"+ 
        t1.getcreation_date() + " ," + 
        t1.getpriority() + " ," + 
        t1.getcategory() + " ,"+ 
        t1.getdeadline()+" ,"+ 
        t1.getestimated_time()+ " ," + 
        t1.getstatus());*/
    }
}