import java.util.Scanner;

/**
 * @author Jaeren Tredway
 * @version 1.0 2019-09-06
 */
public class Pig {
    /**
     * This program plays a game where users take turns rolling dice, adding
     * the result to their total score. But a  roll of one ends the turn with
     * zero points scored. First player to 100 wins.
     *
     * @param args Command line arguments are ignored.
     */
    public static void main(String[] args) {
        // VARIABLES SECTION: ***********************
        int p1Score = 0;
        int p2Score = 0;
        int turn = 1;
        int numPlayers;
        Scanner scanner = new Scanner(System.in);
        //String answer; ...keep it local scope?....
        boolean gameSession = true;

        // GAME SETUP SECTION: **********************
        System.out.println("WELCOME TO THE PIG GAME!");
        numPlayers = 2;
        //TODO: add feature for more players
        String[] players = new String[numPlayers];
        int[] scores = new int[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Player " + (i + 1) + ", enter your name: ");
            scanner.hasNext();
            players[i] = scanner.nextLine();
        }

        System.out.print("Okay " + players[0]);
        for (int i = 1; i < numPlayers; i++) {
            System.out.print(" and " + players[i]);
        }
        System.out.println("...let's play the Pig Game!");

        //GAME PLAY SECTION: **************************
        do {
            while (p1Score < 100 && p2Score < 100) {
                //START OF TURN:
                System.out.println("\nTURN " + turn);
                System.out.println("SCORE: " + players[0] + ": " + scores[0] + " vs" +
                        ". " + players[1] + ": " + scores[1]);
                for (int i = 0; i < 2; i++) {
                    //START OF ONE PLAYER'S TURN:
                    boolean activeTurn;
                    int turnScore = 0;
                    do {
                        System.out.println(players[i] + ", it is your turn: ");
                        int roll = (int) (Math.random() * 6) + 1;
                        System.out.println("You rolled a " + roll);
                        if (roll == 1) {
                            System.out.println(players[i] + ", you lost your " +
                                    "points for this turn!\n");
                            turnScore = 0;
                            activeTurn = false;
                        } else {
                            turnScore = turnScore + roll;
                            System.out.println(players[i] + ", you have " + turnScore + " points.");
                            System.out.println("Roll again? ");
                            String answer = scanner.nextLine();
                            activeTurn = (answer.equals("y")) ? true : false;
                        }
                    } while (activeTurn == true);
                    scores[i] += turnScore;
                } //END OF ONE PLAYER'S TURN
                turn++;
            } //END OF TURN

            if (scores[0] >= 100) {
                System.out.println("\nCongratulations, " + players[0] + " YOU WIN!");
            } else if (scores[1] >= 100) {
                System.out.println("\nCongratulations, " + players[1] + " YOU WIN!");
            }

            System.out.println("\nShall we play again? (y/n): ");
            String answer = scanner.nextLine();
            gameSession = (answer.equals("y")) ? true : false;

        } while (gameSession ==  true);
        System.out.println("Goodbye, thanks for playing the Pig Game!");
        // END OF GAME PLAY SECTION
    } // END OF main() METHOD
} // END OF Class Pig
