/**
 * CS152 Lab 4 -- Welcome to Methods.
 *
 * Implement all the methods described below.
 *
 * Student name: Jaeren Tredway
 */
public class MethodPractice {

    /**
     * Returns largest of its arguments.
     * @param x First argument
     * @param y Second argument
     * @param z Third argument
     * @return Maximum of x, y and z
     */
    public static int findLargest( int x, int y, int z) {
        int largest = (x > y) ? x : y;
        largest = (z > largest) ? z : largest;
        return largest;
    }

    /**
     * Is the argument even?
     * (Recall that even numbers are divisible by 2)
     * @param x Value to check.
     * @return True if x is an even number, false otherwise.
     */
    public static boolean isEven( int x ) {
        return (x % 2 == 0);
    }

    /**
     * Does the given string contain the letter G (either upper or
     * lower case)?
     * @param x String to check
     * @return True if x contains G, false otherwise.
     */
    public static boolean hasG( String x ) {
        return x.toLowerCase().contains("g");
    }

    /**
     * Where is the location of the letter G (upper or lower case) in
     * the given string?
     * @param x String to check
     * @return 0 based location of first occurrence of G in x,
     *         -1 if G is not present.
     */
    public static int indexOfG( String x ) {
        return x.indexOf("G");
    }

    /**
     * This method returns a response based on the string input:
     *     Apple => Orange
     *     Hello => Goodbye!
     *     Turing => Machine
     *     Yay! => \o/
     * Any other input should be responded to with:
     *     What should I say?
     * @param input The input string
     * @return Corresponding output string.
     */
    public static String respond( String input ) {
        return (input.equals("Apple")) ? "Orange" :
            (input.equals("Hello")) ? "Goodbye!" :
            (input.equals("Turing")) ? "Machine" :
            (input.equals("Yay!")) ? "|o/" : "What should I say?";
    }

    /**
     * Average up to five even numbers. Any odd values are
     * not included in the average.
     * @param a First value
     * @param b Second value
     * @param c Third value
     * @param d Fourth value
     * @param e Fifth value
     * @return Average of the even input values. If none are even, returns -1000.
     */
    public static double averageOfEvensOnly( int a, int b, int c, int d, int e ) {

        return -4.2;
    }


    // WRITE A METHOD FROM SCRATCH
    //
    // Write a method called doubleOddSquareEven that returns twice
    // odd numbers and returns even values squared.
    //
    // The method should take a single int argument and return an int
    //
    // Don't forget to use the public static modifiers



    // WRITE A METHOD FROM SCRATCH
    //
    // Write a method called computeMealTotal that takes two
    // arguments, an int meal which is the cost of a meal, and a
    // double tip which represents the tip percentage one would add to
    // the bill.
    // The method must return a double which equals how much should be
    // paid.
    //
    // int meal must be greater than 0
    // double tip must be 0 or greater and .7 or less (no tips over 70%)
    // If either number is invalid, return -1;
    //
    // Don't forget to use the public static modifiers





    // This code tests your program's completeness.
    public static void main(String[] args) {
        int numCorrect = 0;

        if( findLargest(1, 2, 3) == 3 ) { numCorrect++; }
        if( findLargest(4,-5, 2) == 4 ) { numCorrect++; }
        if( findLargest(0, 7, 5) == 7 ) { numCorrect++; }

        if( !isEven(3) ) { numCorrect++; }
        if( isEven(-2) ) { numCorrect++; }
        if( isEven(0) ) { numCorrect++; }

        if( !hasG( "man" ) ) { numCorrect++; }
        if( hasG( "dog" ) ) { numCorrect++; }
        if( hasG( "EGGSHELL" ) ) { numCorrect++; }

        if( indexOfG( "man" ) == -1 ) { numCorrect++; }
        if( indexOfG( "EGGSHELL" ) == 1 ) { numCorrect++; }
        if( indexOfG( "dog" ) == 2 ) { numCorrect++; }
        if( indexOfG( "xyzggGGggG" ) == 3 ) { numCorrect++; }
        if( indexOfG( "xyzGGggGGg" ) == 3 ) { numCorrect++; }

        if( respond( "Apple" ).equals( "Orange" ) ) { numCorrect++; }
        if( respond( "Hello" ).equals( "Goodbye!" ) ) { numCorrect++; }
        if( respond( "Turing" ).equals( "Machine" ) ) { numCorrect++; }
        if( respond( "Yay!" ).equals( "\\o/" ) ) { numCorrect++; }
        if( respond( "xyz" ).equals( "What should I say?" ) ) { numCorrect++; }

        if( averageOfEvensOnly(12, 13, 12, 13, 12) == 12.0) { numCorrect++; }
        if( averageOfEvensOnly(-1, 3, -5, 7, 9) == -1000.0) { numCorrect++; }
        if( averageOfEvensOnly(0, 0, 15, 0, -2) == -0.5) { numCorrect++; }
        if( averageOfEvensOnly(100, -3, 4021, -2, 13) == 49.0) { numCorrect++; }

        // Uncomment these tests AFTER IMPLEMENTING doubleOddSquareEven
        // if( doubleOddSquareEven( 4 ) == 16 ) { numCorrect++; }
        // if( doubleOddSquareEven( 3 ) == 6 ) { numCorrect++; }

        // Uncomment these tests AFTER IMPLEMENTING computeMealTotal
        // if( computeMealTotal( 0, .3 ) == -1 ) { numCorrect++; }
        // if( computeMealTotal( 10, .2 ) == 12.0 ) { numCorrect++; }
        // if( computeMealTotal( 100, .5 ) == 150 ) { numCorrect++; }
        // if( computeMealTotal( 100, .71 ) == -1 ) { numCorrect++; }
        // if( computeMealTotal( 120, .32 ) == 158.4 ) { numCorrect++; }

        System.out.println( "Your program's completeness is currently: "
                            + numCorrect + "/30" );
    }

}
