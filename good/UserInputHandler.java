public class UserInputHandler {
    public static String readLine(String prompt) {
        System.out.println(prompt);
        return System.console().readLine();
    }
}