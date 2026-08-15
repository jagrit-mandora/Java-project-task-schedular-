import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Taskfile{
    private String task_id;
    private String title;
    private String description;
    private Priority priority;
    private Category category;
    private LocalDate creation_date;
    private LocalDateTime deadline;
    private LocalDateTime completion_date;
    private Duration estimated_time;
    private Status status;

    public Taskfile (String task_id, String title, String description,Priority priority,Category category, LocalDateTime deadline, Duration estimated_time){
        this.task_id=task_id;
        this.title=title;
        this.description=description;
        this.creation_date=LocalDate.now();
        this.priority=priority;
        this.category=category;
        this.deadline=deadline;
        this.completion_date=completion_date;
        this.estimated_time=estimated_time;
        this.status=Status.NOT_STARTED;
    }

    public String gettask_id() {return task_id;}
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