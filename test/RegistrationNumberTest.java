import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Cree on 26/02/2017.
 */
public class RegistrationNumberTest {

    @Test
    public void createNewRegistrationNumberShouldCreateValidRegistrationNumber() {
        RegistrationNumber reg = RegistrationNumber.getInstance();
        Assert.assertNotNull(reg);
    }

    @Test
    public void getLetterShouldReturnA() {
        RegistrationNumber reg = RegistrationNumber.getInstance();
        Assert.assertTrue(String.valueOf(reg.getLetter()).equals("a"));
    }

    @Test
    public void getNumbersShouldReturn1ForSecondObjectCreated() {
        RegistrationNumber reg = RegistrationNumber.getInstance();
        RegistrationNumber reg1 = RegistrationNumber.getInstance();
        Assert.assertTrue(reg1.getNumbers() == 1);
    }

    @Test
    public void setLetterCountShouldSetNextInstancesLetter() {
        RegistrationNumber.setLettersCount('z');
        RegistrationNumber reg1 = RegistrationNumber.getInstance();
        Assert.assertTrue(String.valueOf(reg1.getLetter()).equals("z"));
    }

    @Test
    public void setNumbersCountShouldSetNextInstancesNumber() {
        RegistrationNumber.setNumbersCount(9999);
        RegistrationNumber reg1 = RegistrationNumber.getInstance();
        Assert.assertTrue(reg1.getNumbers() == 9999);
    }

    @Test
    public void after9999thInstanceNumberShouldChangeToZeroAndLetterShouldIncrement() {
        RegistrationNumber.setNumbersCount(9999);
        RegistrationNumber reg = RegistrationNumber.getInstance();
        RegistrationNumber reg1 = RegistrationNumber.getInstance();
        System.out.println(reg.toString());
        System.out.println(reg1.toString());
        Assert.assertTrue(String.valueOf(reg1.getLetter()).equals("b"));
        Assert.assertTrue(reg1.getNumbers() == 0);
    }

    @Test
    public void after259974thInstanceShouldReturnNull() {
        RegistrationNumber.setNumbersCount(9999);
        RegistrationNumber.setLettersCount('z');
        RegistrationNumber reg = RegistrationNumber.getInstance();
        RegistrationNumber reg1 = RegistrationNumber.getInstance();
        Assert.assertNotNull(reg);
        Assert.assertNull(reg1);
    }



}
