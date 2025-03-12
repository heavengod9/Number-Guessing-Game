import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;
        do {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");

            // Select difficulty level
            System.out.println("Please select the difficulty level:");
            System.out.println("1. Easy (10 chances)");
            System.out.println("2. Medium (5 chances)");
            System.out.println("3. Hard (3 chances)");
            System.out.print("Enter your choice: ");
            int difficulty = scanner.nextInt();
            int chances = 0;

            switch (difficulty) {
                case 1:
                    chances = 10;
                    break;
                case 2:
                    chances = 5;
                    break;
                case 3:
                    chances = 3;
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Medium.");
                    chances = 5;
            }

            // Start the game
            Random random = new Random();
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            long startTime = System.currentTimeMillis();

            System.out.println("Great! You have selected the " + (difficulty == 1 ? "Easy" : difficulty == 2 ? "Medium" : "Hard") + " difficulty level.");
            System.out.println("Let's start the game!");

            while (chances > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == number) {
                    guessedCorrectly = true;
                    long endTime = System.currentTimeMillis();
                    long timeTaken = (endTime - startTime) / 1000;
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    System.out.println("It took you " + timeTaken + " seconds to guess the number.");
                } else if (guess < number) {
                    System.out.println("Incorrect! The number is greater than " + guess + ".");
                } else {
                    System.out.println("Incorrect! The number is less than " + guess + ".");
                }

                chances--;
                if (chances > 0 && !guessedCorrectly) {
                    System.out.println("You have " + chances + " chances left.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of chances. The correct number was " + number + ".");
            }

            // Ask user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing the Number Guessing Game! Goodbye!");
        scanner.close();
    }
}
