import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Taskfile{

    private int task_id;
    private String title;
    private String description;
    private Priority priority;
    private Category category;
    private LocalDate creation_date;
    private LocalDateTime deadline;
    private LocalDateTime completion_date;
    private Duration estimated_time;
    private Status status;

    public Taskfile (
        String title,
        String description,
        Priority priority,
        Category category,
        LocalDateTime deadline,  
        Duration estimated_time){
            
        this.title=title;
        this.description=description;
        this.creation_date=LocalDate.now();
        this.priority=priority;
        this.category=category;
        this.deadline=deadline;
        this.estimated_time=estimated_time;
        this.status=Status.TODO;
    }

    public Taskfile (
        int task_id,
        String title,
        String description,
        Priority priority,
        Category category,
        LocalDate creation_date,
        LocalDateTime deadline,
        LocalDateTime completion_date,
        Duration estimated_time,
        Status status){
            
        this.task_id=task_id;
        this.title=title;
        this.description=description;
        this.creation_date=creation_date;
        this.priority=priority;
        this.category=category;
        this.creation_date=creation_date;
        this.deadline=deadline;
        this.completion_date=completion_date;
        this.estimated_time=estimated_time;
        this.status=status;
    }

    public String tostring(){
        return
        task_id + " ," + 
        title + " ," + 
        description +" ,"+ 
        creation_date + " ," + 
        priority + " ," + 
        category + " ,"+ 
        deadline +" ,"+ 
        estimated_time + " ," + 
        status + "," +
        completion_date;
    }

    public void settask_id(int task_id) {this.task_id=task_id;}
    public void settitle(String title) {this.title=title;}
    public void setdescription(String description) {this.description=description;}
    public void setpriority(Priority priority) {this.priority=priority;}
    public void setcategory(Category category) {this.category=category;}
    public void setcompletion_date(LocalDateTime completion_date) {this.completion_date=completion_date;}
    public void setcreation_date(LocalDate creation_date) {this.creation_date=creation_date;}
    public void setdeadline(LocalDateTime deadline) {this.deadline=deadline;}
    public void setestimated_time(Duration estimated_time) {this.estimated_time=estimated_time;}
    public void setstatus(Status status) {this.status=status;}


    public int gettask_id() {return task_id;}
    public String gettilte() {return title;}
    public String getdescription() {return description;}
    public LocalDate getcreation_date() {return creation_date;}
    public Priority getpriority() {return priority;}
    public Category getcategory() {return category;}
    public LocalDateTime getdeadline() {return deadline;}
    public LocalDateTime getcompletion_date() {return completion_date;}
    public Duration getestimated_time() {return estimated_time;}
    public Status getstatus() {return status;}



}