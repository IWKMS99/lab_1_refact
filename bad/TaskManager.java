import java.util.Arrays;

public class TaskManager {

    private Task[] tasks = new Task[10];

    private int size = 0;

    public void addTask() {

        if (size == tasks.length) {

            Task[] newTasks = new Task[tasks.length * 2];

            for (int i = 0; i < size; i++) {

                newTasks[i] = tasks[i];

            }

            tasks = newTasks;

        }

        System.out.println("Enter task name:");

        String name = System.console().readLine();

        System.out.println("Enter task description:");

        String description = System.console().readLine();

        Task task = new Task();

        task.name = name;

        task.description = description;

        task.isCompleted = false;

        tasks[size] = task;

        size++;

        System.out.println("Task added successfully.");

        saveTasksToFile();

    }


    public void removeTask() {

        System.out.println("Enter task name to remove:");

        String name = System.console().readLine();

        for (int i = 0; i < size; i++) {

            if (tasks[i].name.equals(name)) {

                for (int j = i; j < size - 1; j++) {

                    tasks[j] = tasks[j + 1];

                }

                size--;

                System.out.println("Task removed successfully.");

                saveTasksToFile();

                return;

            }

        }

        System.out.println("Task not found.");
    }

    public void markTaskAsCompleted() {

        System.out.println("Enter task name to mark as completed:");

        String name = System.console().readLine();

        for (int i = 0; i < size; i++) {

            if (tasks[i].name.equals(name)) {

                tasks[i].isCompleted = true;

                System.out.println("Task marked as completed.");

                saveTasksToFile();

                return;

            }

        }

        System.out.println("Task not found.");

    }

    public void viewTasks() {

        System.out.println("List of tasks:");

        for (int i = 0; i < size; i++) {

            String status = tasks[i].isCompleted ? "Completed" : "Not completed";

            System.out.println("Name: " + tasks[i].name + ", Description: " + tasks[i].description + ", Status: " + status);

        }

    }

    private void saveTasksToFile() {

        // Placeholder for file saving logic

    }

    public void loadTasksFromFile() {

        // Placeholder for file loading logic

    }
}