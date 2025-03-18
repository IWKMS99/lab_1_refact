public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        while (true) {

            System.out.println("1. Add task");

            System.out.println("2. Remove task");

            System.out.println("3. Mark task as completed");

            System.out.println("4. View tasks");

            System.out.println("5. Exit");

            System.out.println("Enter your choice:");

            String choice = System.console().readLine();

            if (choice.equals("1")) {

                manager.addTask();

            }

            else if (choice.equals("2")) {

                manager.removeTask();

            }

            else if (choice.equals("3")) {

                manager.markTaskAsCompleted();

            }

            else if (choice.equals("4")) {

                manager.viewTasks();

            }

            else if (choice.equals("5")) {

                break;

            }

            else {

                System.out.println("Invalid choice.");

            }

        }

    }

}