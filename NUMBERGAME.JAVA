import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 5; 
    private static int attemptsLeft;
    private static int score;
    private static int randomNumber;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            startNewRound();

            while (attemptsLeft > 0) {
                System.out.print("Guess a number between 1 and 100 (Attempts left: " + attemptsLeft + "): ");
                
                
                int userGuess = scanner.nextInt();

                
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attemptsLeft--;

                
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number!");
                    score += (attemptsLeft + 1) * 10; 
                    System.out.println("Your score: " + score);
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                if (attemptsLeft <= 0) {
                    System.out.println("Game over! The number was " + randomNumber + ".");
                }
            }

           
            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); 
            String playAgain = scanner.nextLine();

            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Final Score: " + score);
                System.out.println("Thank you for playing!");
                break;
            }
        }

        scanner.close();
    }

    private static void startNewRound() {
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1; 
        attemptsLeft = MAX_ATTEMPTS;
        System.out.println("New round started! Guess a number between 1 and 100.");
    }
}
