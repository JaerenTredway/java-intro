/**
 * This class builds an Author object with a first name, surname, birth year and
 * death year
 * @author Jaeren W. Tredway
 * @version 1.0
 */
public class Author {

    //TODO: INSTANCE VARIABLES: ****************************************
    private String givenName;
    private String surname;
    private int birth;
    private int death;


    //TODO: CLASS (STATIC) VARIABLES:***********************************
    // None so far.


    //TODO: CONSTRUCTOR: ***********************************************
    /**
     * Constructor for Author objects
     * @param givenName
     * @param surname
     */
    public Author(String givenName, String surname) {
        this.givenName = givenName;
        this.surname = surname;
    }//END Author constructor


    //TODO: SETTERS: ****************************************************
    public void setLifeRange(int birth) {
        if (birth > -2000 && birth < 2024) {
            this.birth = birth;
        } else {
            System.out.println("Invalid birth year");
        }
    }

    public void setLifeRange(int birth, int death) {
        if ((birth > -2000 && birth < 2024) && (birth < death)) {
            this.birth = birth;
        } else {
            System.out.println("Invalid birth and/or death year");
        }
    }


    //TODO: GETTERS: ****************************************************
    public int getBirthYear() {
        return birth;
    }

    public int getDeathYear() {
        return death;
    }


    //TODO: HELPER METHODS: *********************************************
    public boolean hasSameName(Author other) {
        boolean sameName = false;

        //test if first and last names match:
        if ((other.givenName.equals(this.givenName)) &&
            (other.surname.equals(this.surname))) {
            sameName = true;
        }

        //test if first initials (no period) and last names match:
        if (this.givenName.length() == 1 || other.givenName.length() == 1) {
            if (this.givenName.charAt(0) == other.givenName.charAt(0)) {
                sameName = true;
            }
        }
        //test if first initials (followed by period) and last names match:
        if (this.givenName.length() > 1 && other.givenName.length() > 1) {
            if (
                (this.givenName.charAt(0) == other.givenName.charAt(0)) &&
                (this.givenName.charAt(1) == '.' || other.givenName.charAt(1)
                        == '.')) {
                sameName = true;
            }
        }

        return sameName;
    }

//    public String toString() {
//
//    }
//
//    public String getInfoString() {
//
//    }

    //TODO: main() method ***********************************************
    public static void main(String[] args) {
        Author sciFi_1 = new Author("William", "Gibson");
        Author sciFi_2 = new Author("Isaac", "Azimov");
        Author sciFi_3 = new Author("W.", "Gibson");

        System.out.println(sciFi_1.givenName + " " + sciFi_1.surname);
        System.out.println(sciFi_2.givenName + " " + sciFi_2.surname);
        System.out.println(sciFi_3.givenName + " " + sciFi_3.surname);

        System.out.println(sciFi_1.hasSameName(sciFi_3));

        sciFi_1.setLifeRange(1980, 2020);


    }


    //TODO: what is an "overloaded method"?
    //TODO: what is a member variable vs. instance variable?
}//END Author class
