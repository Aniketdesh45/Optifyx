import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        
        // Initialize the number of tries
        int numberOfTries = 0;
        
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        
        System.out.println(">>>  Welcome to Guess the Number <<<<");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Try to guess it in as few attempts as possible.");
        System.out.println("....Lets Start the Game.....");
        System.out.println("");
        while (true) {
            
            System.out.println("");
            System.out.print("Enter your guess: ");
            int userGuess = input.nextInt();
            numberOfTries++;
            
            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println(" Congratulations! You found the number in " + numberOfTries + " tries.");

                System.out.println("....Play Again And Have Fun.....");
                break;
            }
        }
        
        input.close();
    }
}