import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineReservationSystem {
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, String> reservations = new HashMap<>();

    public static void main(String[] args) {
        users.put("user1", "password1"); // Sample user
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Reservation System");
        System.out.print("Enter login ID: ");
        String loginId = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticateUser(loginId, password)) {
            System.out.println("Login successful!");
            boolean exit = false;
            while (!exit) {
                System.out.println("1. Make a Reservation");
                System.out.println("2. Cancel a Reservation");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        makeReservation(scanner);
                        break;
                    case 2:
                        cancelReservation(scanner);
                        break;
                    case 3:
                        exit = true;
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

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey: ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter from (place): ");
        String from = scanner.nextLine();
        System.out.print("Enter to (destination): ");
        String to = scanner.nextLine();

        String pnr = "PNR" + (reservations.size() + 1);
        String reservationDetails = String.format("Name: %s, Train: %s, Class: %s, Date: %s, From: %s, To: %s",
                name, trainNumber, classType, dateOfJourney, from, to);
        reservations.put(pnr, reservationDetails);

        System.out.println("Reservation successful! Your PNR is " + pnr);
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter PNR number: ");
        String pnr = scanner.nextLine();

        if (reservations.containsKey(pnr)) {
            System.out.println("Reservation details: " + reservations.get(pnr));
            System.out.print("Do you want to cancel this reservation? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                reservations.remove(pnr);
                System.out.println("Reservation cancelled successfully.");
            } else {
                System.out.println("Cancellation aborted.");
            }
        } else {
            System.out.println("Invalid PNR number.");
        }
    }
}
