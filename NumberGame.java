import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int score = 0; // counts how many rounds the user wins
        String playAgain;

        System.out.println("🎯 Welcome to the Number Guessing Game! 🎯");

        do {
            int lowerBound = 1;
            int upperBound = 100;
            int randomNumber = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int maxAttempts = 7; // limit attempts per round
            boolean isCorrect = false;

            System.out.println("\nI have selected a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts!");
                    score++;
                    isCorrect = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("📉 Too low! Try again.");
                } else {
                    System.out.println("📈 Too high! Try again.");
                }
            }

            if (!isCorrect) {
                System.out.println("❌ You've used all attempts! The correct number was: " + randomNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n🏁 Game Over!");
        System.out.println("✅ Your Final Score (Rounds Won): " + score);
        System.out.println("Thanks for playing! 😊");

        sc.close();
    }
}