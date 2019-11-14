public class Library {

    /** Unique books in the library. */
    public Book[] books;

    /** Number of copies for each book. */
    private int[] copies;

    /** Number of copies currently on the shelf (checked in) for each book. */
    private int[] checkedIn;

    /** Number of unique books in the library. */
    private int numBooks;

    /** Construct a new empty Library. */
    public Library(int librarySize) {
        books = new Book[librarySize];
        copies = new int[librarySize];
        checkedIn = new int[librarySize];
        numBooks = 0;
    }

    /**
     * Get the number of total copies of all books that exist in the
     * library.
     * @return Total number of copies in the library.
     */
    public int getTotalCopies() {
        int totalCopies = 0;

        for (int i = 0; i < copies.length; i++) {
            totalCopies += copies[i];
            //System.out.println("copies " + i + ": " + copies[i]);
        }
        return totalCopies;
    }

    /**
     * Get the number of copies currently checked out.
     * @return Total number of copies checked out.
     */
    public int getNumCheckedOut() {
        int totalCopies = getTotalCopies();
        int totalCheckedIn = 0;

        for (int i = 0; i < checkedIn.length; i++) {
            totalCheckedIn += checkedIn[i];
        }

        return totalCopies - totalCheckedIn;
    }

    /**
     * Get a String representing the status of the library.
     * @return Status string.
     */
    public String getStatus() {
        String result =
                "Total unique books: " + numBooks + "\n" +
                "Total number of copies: " + getTotalCopies() + "\n" +
                "Total checked out: " + getNumCheckedOut();

        return result;
    }


    /**
     * Add a single book to the library, on the shelf.
     *
     * If the book is already present, adds another copy.
     * If the book is new, add it after the existing books.
     * @param b Book to add.
     */
    public void addBook( Book b ) {
        boolean alreadyInLibrary = false;

        //search if you already have this book:
        for (int i = 0; i < books.length; i++) {
            //if you reached the end of the books, stop looking:
            if (books[i] == null) {
                break;
            //if you already have this book in your library, add a copy:
            } else if (b.equals(books[i])) {
                copies[i]++;
                checkedIn[i]++;
                //numBooks++; >>this is not a new copy
                alreadyInLibrary = true;
                break;
            }
        }

        //if you don't have this book yet, add it to the first available
        // space in your library:
        if (!alreadyInLibrary) {
            for (int i = 0; i < books.length; i++) {
                if (books[i] == null) {
                    books[i] = b;
                    copies[i] = 1;
                    checkedIn[i] = 1;
                    numBooks++;
//                    System.out.println("new book = " + b.getTitle());
//                    System.out.println("added book = " + books[i].getTitle());
                    break;
                }
            }
        }
    }//END of addBook() (Adds single book)*******************************


    /**
     * Add all the books in the array to the library. Adds one copy of
     * each book.
     * @param newBooks Books to add.
     */
    public void addBooks( Book[] newBooks ) {
        //find first empty position on bookshelf:
        int startPosition = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                startPosition = i;
                break;
            }
        }
        //add the newBooks starting at startPosition:
        for (int i = startPosition; i < startPosition + newBooks.length; i++) {
            addBook(newBooks[i-startPosition]);
        }
    }//END of addBooks() (Adds array of books)****************************


    /**
     * Checks out a book from the library if possible.
     * @param b Book to check out.
     * @return String denoting success or failure.
     */
    public String checkOut ( Book b ) {
        String action = "Book not found.";

        for (int i = 0; i < numBooks; i++) {
            //eject out of this method if either book involved is null:
            if (books[i] == null) {
                System.out.println("One or more books are missing, action " +
                        "terminated");
                //eject:
                return action;
            }

            if (books[i].equals(b)) {
                //System.out.println("\nSquaaAAAKK!ONE\n");
                if (checkedIn[i] >= 1) {
                    //System.out.println("\nSquaaAAAKK!TWO\n");
                    action = "Checked out!";
                    checkedIn[i] = checkedIn[i] - 1;
                } else {
                    //System.out.println("\nSquaaAAAKK!THREE\n");
                    action = "All out of copies.";
                }
            }
            //System.out.println(getStatus());
        }

        return action;
    }


    /**
     * Checks in a book to the library if possible.
     * @param b Book to check in.
     * @return String denoting success or failure.
     */
    public String checkIn ( Book b ) {
        String action = "";

        for (int i = 0; i < numBooks; i++) {

            if (books[i].equals(b) && checkedIn[i] < copies[i]) {
                checkedIn[i]++;
                action = "Checked in!";
                break;
            } else if (books[i].equals(b) && (checkedIn[i] == copies[i])) {
                action = "All of our copies are already checked in.";
                break;
            } else {
                action = "Book not found.";
            }
        }

        return action;
    }


    /**
     * Get string representation of entire library collection and status.
     * @return String representation of library.
     */
    public String toString() {
        String output = "";

        for (int i = 0; i < numBooks; i++) {
            output += i + ". " +
                    books[i].getTitle() +
                    ". " + books[i].getAuthor() + ". : " +
                    checkedIn[i] + "/" + copies[i] + "\n";
        }
        output +=   "\nTotal unique books: " + numBooks +
                    "\nTotal number of copies: " + getTotalCopies() +
                    "\nTotal checked out: " + getNumCheckedOut();

        System.out.println(output);
        return output;
    }


    /**
     * Get number of unique books that exist for a given author.
     * @param a The author to check.
     * @return Number of books by the author.
     */
    public int numBooksByAuthor( Author a ) {
        int counter = 0;

        for (int i = 0; i < numBooks; i++) {

            if (books[i].getAuthor().hasSameName(a)) {
                System.out.println("Target: " + a.toString() + "/ located: " + books[i].getAuthor() +
                        "**********\n");
                counter++;
            }
        }

        return counter;
    }

    /**
     * Returns a String that lists the unique books which exist for a
     * given author, in standard book format, with a newline after
     * each.  If no books are found for the author, returns string
     * that says so.
     *
     * @param a The author in question.
     * @return String listing books by the author.
     */
    public String listBooksByAuthor( Author a ) {
        return "";
    }

    /**
     * Returns string that lists the unique books with contain the
     * given string within their titles, without regard for case, with
     * a newline after each.  If no books are found containing the
     * string, returns string that says so.
     * @param s The string to look for in the titles.
     * @return String listing books that contain given string in titles.
     */
    public String listBooksByTitle( String s ) {
        return "";
    }

    /**
     * Deletes book entirely from the library.
     * @param b Book to remove.
     * @return String denoting success or failure.
     */
    public String deleteBook( Book b ) {
        // This method is for optional bonus points.
        return "";
    }

}
