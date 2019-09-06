import java.util.Scanner;

public class Pig {
    public static void main(String[] args) {
        int p1Score = 0;
        int p2score = 0;
        Scanner scanner = new Scanner(System.in);
        String p1Name, p2Name;
        int turn = 1;

        System.out.print("Player one, enter your name: ");
        p1Name = scanner.nextLine();
        System.out.print("Player two, enter your name: ");
        p2Name = scanner.nextLine();

        System.out.print(p1Name + " and " + p2Name + " welcome to the Pig " +
                "game, let's do this!\n");

        while (p1Score < 100 && p2score < 100) {
            System.out.println("\nTURN " + turn);

            break;
        }

        if (p1Score >= 100) {
            System.out.println("Congratulations, " + p1Name + " YOU WIN!");
        } else {
            System.out.println("Congratulations, " + p2Name + " YOU WIN!");
        }
    }
}
