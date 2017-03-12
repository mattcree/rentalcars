/**
 * A class representing a real world name. Only first name and last name.
 */
public class Name {

    private String firstName;
    private String lastName;

    /**
     * Constructor. All parameters required.
     * @param firstName A first name
     * @param lastName A last name/surname
     */
    public Name (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns a string of initials
     * @return
     */
    public String getInitials() {
        return (firstName.substring(0,1) + lastName.substring(0,1)).toUpperCase();
    }

    /**
     * Returns a string representation of a full name,
     * first name plus last name.
     * @return
     */
    public String toString() {
        return firstName + " " + lastName;
    }

}
