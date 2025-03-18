public class Main {
    public static void main(String[] args) {
        TaskPersister persister = new TaskPersister();
        TaskManager manager = new TaskManager(persister);
        while (true) {
            displayMenu();
            String choice = UserInputHandler.readLine("Enter your choice:");
            switch (choice) {
                case "1" -> {
                    String name = UserInputHandler.readLine("Enter task name:");
                    String desc = UserInputHandler.readLine("Enter task description:");
                    manager.addNewTask(name, desc);
                    break;
                }
                case "2" -> {
                    String nameToRemove = UserInputHandler.readLine("Enter task name to remove:");
                    manager.deleteTaskByName(nameToRemove);
                    break;
                }
                case "3" -> {
                    String nameToComplete = UserInputHandler.readLine("Enter task name to mark as completed:");
                    manager.setTaskCompletedByName(nameToComplete);
                    break;
                }
                case "4" -> {
                    manager.displayAllTasks();
                    break;
                }
                case "5" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid choice.");
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add task");
        System.out.println("2. Remove task");
        System.out.println("3. Mark task as completed");
        System.out.println("4. View tasks");
        System.out.println("5. Exit");
    }
}