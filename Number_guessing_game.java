import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int maxAttempts = 3;
        int score = 0;
        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 0;
            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Guess a number between 1 and 100: ");
                int userGuess = input.nextInt();
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations, you guessed the number!");
                    score = calculateScore(attempts);
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Your guess is too low. Try again.");
                }
            }
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you have exceeded the maximum number of attempts. The number was " + numberToGuess + ".");
            }
            System.out.println("Your score is: " + score);
            System.out.print("Do you want to play again? (yes or no): ");
            String playAgainStr = input.next();
            playAgain = playAgainStr.equalsIgnoreCase("yes");
        }
    }
    
    public static int calculateScore(int attempts) {
        if (attempts == 1) {
            return 10;
        } else if (attempts == 2) {
            return 7;
        } else {
            return 5;
        }
    }
}
