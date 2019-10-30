/**
 * This class builds an Book object with a year, title, ISBN and author
 * @author Jaeren W. Tredway
 * @version 1.0
 */
public class Book {
    //TODO: INSTANCE MEMBER VARIABLES: ***************************
        private int date = AuthorBookConstants.UNKNOWN_YEAR;
        private String title = AuthorBookConstants.UNKNOWN_TITLE;
        private String isbn = AuthorBookConstants.UNKNOWN_ISBN;
        private Author author = AuthorBookConstants.UNKNOWN_AUTHOR;

    //TODO: CLASS (STATIC) MEMBER VARIABLES: *********************
    //none so far

    //TODO: 3 CONSTRUCTORS****************************************
    public Book() {
        this("UNKNOWN");
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    //TODO: 4 SETTERS: *******************************************
    public void setTitle(String title) {
        if (title == null) {
            System.out.println("Null name was ignored.");
        } else if (title.isEmpty()) {
            System.out.println("Empty name was ignored.");
        } else this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPubYear(int year) {
        if (date > -2000 && date < 2024) {
            this.date = date;
        } else {
            System.out.println("Invalid publication date.");
        }
    }

    public void setIntStdBookNum( String isbn) {
        if (isbn.length() == 10 || isbn.length() == 13) {
            this.isbn = isbn;
        } else {
            System.out.println("Invalid ISBN ignored.");
        }
    }

    //TODO: 4 GETTERS: ********************************************
    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPubYear() {
        return date;
    }

    public String getIntStdBookNum() {
        return isbn;
    }

    //TODO: HELPER METHODS: ****************************************
    public boolean sameAuthor(Book other) {
        if (this.author.hasSameName(other.author)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Book other) {
        if (this.isbn.equals(other.isbn)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        if (author != AuthorBookConstants.UNKNOWN_AUTHOR &&
            date != AuthorBookConstants.UNKNOWN_YEAR) {
            return title + " (" + date + ")." + author.toString() + ".";
        } else if (author != AuthorBookConstants.UNKNOWN_AUTHOR) {
            return title + ". " + author.toString() + ".";
        } else {
            return title + ".";
        }
    }

    public static void main(String[] args) {
        Author sciFi_1 = new Author("William", "Gibson");
        Author sciFi_2 = new Author("Isaac", "Azimov");
        Author sciFi_3 = new Author("W.", "Gibson");
        Book book_1 = new Book("Neuromancer", sciFi_1);
        Book book_2 = new Book("Count Zero", sciFi_3);
        Book book_3 = new Book("I, Robot", sciFi_2);
        System.out.println(sciFi_1.hasSameName(sciFi_3));
        sciFi_1.setLifeRange(1960, 2020);
        System.out.println(sciFi_1.getInfoString());
        System.out.println(book_1.toString());
        System.out.println(book_1.sameAuthor(book_2));

    }

}//END of class Book
