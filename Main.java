
import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
    Taskfile t1= new Taskfile("1","testing", "to check if this works",Priority.URGENT, Category.WORK,LocalDateTime.of(2026, 04, 16, 15, 13), Duration.ofHours(4));
    System.out.println(t1.gettask_id() + " ," + t1.gettilte() + " ," + t1.getdescription()+" ,"+ t1.getcreation_date() + " ," + t1.getpriority() + " ," + t1.getcategory() + " ,"+" ,"+ t1.getdeadline()+" ,"+ t1.getestimated_time()+ " ," + t1.getstatus());
    }
}