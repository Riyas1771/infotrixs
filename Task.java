import java.io.Serializable;

public class Task implements Serializable {
    private String taskId;
    private String title;
    private String description;
    private User assignee;
    private TaskStatus status;

    public Task(String taskId, String title, String description, User assignee, TaskStatus status) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.assignee = assignee;
        this.status = status;
    }

    // Getters and setters
}

enum TaskStatus {
    NEW,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}
