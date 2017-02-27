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
        int letter = reg.getLetter();
        Assert.assertTrue(reg.getLetter() != 0);
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
    public void getInstance9999thInstanceNumberShouldChangeToZeroAndLetterShouldIncrement() {
        RegistrationNumber.setNumbersCount(9999);
        RegistrationNumber reg = RegistrationNumber.getInstance().getInstance();
        if (reg == null) throw new AssertionError();
        Assert.assertTrue(String.valueOf(reg.getLetter()).equals("b"));
        Assert.assertTrue(reg.getNumbers() == 0);
    }

    @Test
    public void getInstance259975thInstanceShouldReturnNull() {
        RegistrationNumber.setNumbersCount(9999);
        RegistrationNumber.setLettersCount('z');
        RegistrationNumber reg = RegistrationNumber.getInstance();
        RegistrationNumber reg1 = RegistrationNumber.getInstance();
        Assert.assertNull(reg1);
    }


    @Test
    public void toStringShouldReturnRegistrationNumberAsString() {

    }


}
