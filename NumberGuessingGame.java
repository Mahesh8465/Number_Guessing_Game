import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    
    public static void main(String[] args) {
        // Set up the game parameters
        int lowerBound = 1; // Lower bound of the range
        int upperBound = 100; // Upper bound of the range
        int maxAttempts = 10; // Maximum number of attempts
        
        // Create a Random object to generate random numbers
        Random random = new Random();
        // Generate a random number within the range
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.printf("I have selected a number between %d and %d. You have %d attempts to guess it.\n", lowerBound, upperBound, maxAttempts);
        
        int attemptsLeft = maxAttempts;
        boolean hasGuessedCorrectly = false;
        
        while (attemptsLeft > 0 && !hasGuessedCorrectly) {
            System.out.printf("You have %d attempt(s) left. Enter your guess: ", attemptsLeft);
            int userGuess = scanner.nextInt();
            
            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.printf("Please guess a number between %d and %d.\n", lowerBound, upperBound);
            } else if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
                attemptsLeft--;
            } else if (userGuess > targetNumber) {
                System.out.println("Too high! Try again.");
                attemptsLeft--;
            } else {
                System.out.println("Congratulations! You've guessed the number correctly!");
                hasGuessedCorrectly = true;
            }
        }
        
        if (!hasGuessedCorrectly) {
            System.out.printf("Sorry, you've run out of attempts. The number was %d.\n", targetNumber);
        }
        
        scanner.close();
    }
}