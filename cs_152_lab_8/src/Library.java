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

        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                break;
            } else if (b.equals(books[i])) {
                copies[i]++;
                alreadyInLibrary = true;
                break;
            }
        }

        if (!alreadyInLibrary) {
            //make bigger arrays and copy the old data over:
            Book[] biggerBooks = new Book[books.length+1];
            int[] biggerCopies = new int[books.length+1];
            int[] biggerCheckedIn = new int[books.length+1];
            for (int i = 0; i < books.length; i++) {
                biggerBooks[i] = books[i];
                biggerCopies[i] = copies[i];
                biggerCheckedIn[i] = checkedIn[i];
            }
            //add the new book:
            int lastIndex = biggerBooks.length-1;
            biggerBooks[lastIndex] = b;
            biggerCopies[lastIndex] = 1;
            biggerCheckedIn[lastIndex] = 1;
            //point back to the original array names:
            books = biggerBooks;
            copies = biggerCopies;
            checkedIn = biggerCheckedIn;
        }
    }


    /**
     * Add all the books in the array to the library. Adds one copy of
     * each book.
     * @param newBooks Books to add.
     */
    public void addBooks( Book[] newBooks ) {
        for (int i = 0; i < newBooks.length; i++) {
            books[i] = newBooks[i];
            copies[i] = 1;
            checkedIn[i] = 1;
        }
    }

    /**
     * Checks out a book from the library if possible.
     * @param b Book to check out.
     * @return String denoting success or failure.
     */
    public String checkOut ( Book b ) {
        return "";
    }

    /**
     * Checks in a book to the library if possible.
     * @param b Book to check in.
     * @return String denoting success or failure.
     */
    public String checkIn ( Book b ) {
        return "";
    }

    /**
     * Get string representation of entire library collection and status.
     * @return String representation of library.
     */
    public String toString() {
        return "";
    }

    /**
     * Get number of unique books that exist for a given author.
     * @param a The author to check.
     * @return Number of books by the author.
     */
    public int numBooksByAuthor( Author a ) {
        return -1;
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
