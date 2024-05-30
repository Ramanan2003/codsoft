import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        
        System.out.print("Enter the number of rounds you want to play: ");
        int rounds = scanner.nextInt();
        
        System.out.print("Enter the maximum number of attempts allowed per round: ");
        int maxAttempts = scanner.nextInt();

        int totalScore = 0;

        for (int roundNumber = 1; roundNumber <= rounds; roundNumber++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("\nRound " + roundNumber + " of " + rounds);
            System.out.println("You have " + maxAttempts + " attempts to guess the number between 1 and 100.");

            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1);
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }
        }

        System.out.println("\nGame Over! Your total score is: " + totalScore);
        
        scanner.close();
    }
}
