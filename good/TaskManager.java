import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private TaskPersister persister;

    public TaskManager(TaskPersister persister) {
        this.persister = persister;
        this.tasks = persister.loadTasks();
    }

    public void addNewTask(String name, String description) {
        Task task = new Task(name, description);
        tasks.add(task);
        persister.saveTasks(tasks);
    }

    public void deleteTaskByName(String name) {
        Task task = findTaskByName(name);
        if (task != null) {
            tasks.remove(task);
            persister.saveTasks(tasks);
        } else {
            System.out.println("Task not found.");
        }
    }

    public void setTaskCompletedByName(String name) {
        Task task = findTaskByName(name);
        if (task != null) {
            task.setCompleted(true);
            persister.saveTasks(tasks);
        } else {
            System.out.println("Task not found.");
        }
    }

    public void displayAllTasks() {
        System.out.println("List of tasks:");
        for (Task task : tasks) {
            String status = task.isCompleted() ? "Completed" : "Not completed";
            System.out.println("Name: " + task.getName() + ", Description: " + task.getDescription() + ", Status: " + status);
        }
    }

    private Task findTaskByName(String name) {
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
    }
}