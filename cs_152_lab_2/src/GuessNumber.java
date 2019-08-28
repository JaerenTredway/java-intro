import java.util.Scanner;

/**
 * @version 1.0 2019-08-28
 * @author Jaeren Tredway
 */
public class GuessNumber {

    /**
     * This program plays a game with the user by randomly generating a number from 1 to 10
     *  and making the user try to guess it.
     * @param args Command line arguments are ignored.
     */
    public static void main(String[] args) {
        System.out.println("What is your name?");
        Scanner userInput = new Scanner(System.in);
        String userName = userInput.nextLine();
        System.out.println(userName + ", please pick a number between 1 and 10");
        int guess = userInput.nextInt();
        System.out.println("You guessed " + guess);

        int randomNum = (int)(Math.random() * 10) + 1;
        System.out.println("I was thinking of " + randomNum);

        if (randomNum == guess) {
            System.out.println("Congratulations, " + userName + "! You guessed my number! ");
        } else {
            System.out.println("Better luck next time, " + userName);
        }
    } //End of main()
} // End of class GuessNumber
