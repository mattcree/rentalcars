/**
 * Created by Cree on 24/02/2017.
 */
public class Name {

    private String firstName;
    private String lastName;

    public Name (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInitials() {
        return firstName.substring(0,1) + lastName.substring(0,1);
    }

    public String toString() {
        return firstName + " " + lastName;
    }

}
