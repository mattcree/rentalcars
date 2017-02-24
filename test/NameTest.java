import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Cree on 24/02/2017.
 */

public class NameTest {

    @Test
    public void createNewNameShouldCreateValidName() {
        Name name = createName();
        Assert.assertNotNull(name);
    }

    @Test
    public void getFirstNameShouldReturnFirstName() {
        Name name = createName();
        Assert.assertTrue(name.getFirstName().equals(firstName));
    }

    @Test
    public void getLastNameShouldReturnLastName() {
        Name name = createName();
        Assert.assertTrue(name.getLastName().equals(lastName));
    }

    @Test
    public void getInitialsShouldReturnStringComposedOfBothInitials() {
        Name name = createName();
        Assert.assertTrue(name.getInitials().equals("BB"));
    }

    @Test
    public void toStringShouldReturnNameAsString() {
        Name name = createName();
        Assert.assertTrue(name.toString().equals(firstName + " " + lastName));
    }


    //Fields and constructor for tests
    private String firstName = "Barry";
    private String lastName = "Bant";

    private Name createName() {
        return new Name(firstName, lastName);
    }

}
