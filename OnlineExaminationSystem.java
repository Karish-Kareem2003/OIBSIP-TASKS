import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineExaminationSystem {
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, String> profiles = new HashMap<>();
    private static Map<String, String> questions = new HashMap<>();
    private static Map<String, String> answers = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        users.put("user1", "password1"); 
        profiles.put("user1", "User One"); 
        questions.put("Q1", "What is the capital of France?");
        answers.put("Q1", "Paris");

        System.out.println("Welcome to the Online Examination System");
        System.out.print("Enter login ID: ");
        String loginId = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticateUser(loginId, password)) {
            System.out.println("Login successful!");
            boolean exit = false;
            while (!exit) {
                System.out.println("1. Update Profile and Password");
                System.out.println("2. Take Exam");
                System.out.println("3. Logout");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        updateProfile(loginId);
                        break;
                    case 2:
                        takeExam();
                        break;
                    case 3:
                        exit = true;
                        System.out.println("Session closed. Logging out...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid login ID or password.");
        }
        scanner.close();
    }

    private static boolean authenticateUser(String loginId, String password) {
        return users.containsKey(loginId) && users.get(loginId).equals(password);
    }

    private static void updateProfile(String loginId) {
        System.out.print("Enter new profile name: ");
        String newName = scanner.nextLine();
        profiles.put(loginId, newName);
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        users.put(loginId, newPassword);
        System.out.println("Profile and password updated successfully.");
    }

    private static void takeExam() {
        System.out.println("Starting exam...");
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 5 * 60 * 1000; 

        for (Map.Entry<String, String> entry : questions.entrySet()) {
            if (System.currentTimeMillis() > endTime) {
                System.out.println("Time's up! Auto-submitting your answers...");
                break;
            }
            System.out.println(entry.getValue());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            
        }
        System.out.println("Exam completed.");
    }
}
