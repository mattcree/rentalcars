import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Cree on 27/02/2017.
 */
public class LicenceNumberTest {
    @Test
    public void createNewLicenseNumberShouldCreateValidLicenseNumber() {
        LicenceNumber.setSerial(0);
        LicenceNumber number = createNumber();
        Assert.assertNotNull(number);
    }

    @Test
    public void getInitialsShouldReturnInitials() {
        LicenceNumber.setSerial(0);
        LicenceNumber number = createNumber();
        Assert.assertTrue(number.getInitials().equals(initials));
    }

    @Test
    public void getIssueYearShouldReturnYear() {
        LicenceNumber.setSerial(0);
        LicenceNumber number = createNumber();
        Assert.assertTrue(number.getIssueYear() == issueYear);
    }

    @Test
    public void getSerialShouldReturnSerialNumber() {
        LicenceNumber.setSerial(0);
        LicenceNumber number = createNumber();
        Assert.assertTrue(number.getSerial() == 0);
    }

    @Test
    public void getSerialShouldIncrementSerialUponEachNewInstance() {
        LicenceNumber.setSerial(0);
        LicenceNumber number1 = createNumber();
        LicenceNumber number2 = createNumber();
        Assert.assertTrue(number2.getSerial() == 1);
    }

    @Test
    public void getLicenseNumberShouldReturnFullLicenseNumberAsString() {
        LicenceNumber.setSerial(0);
        LicenceNumber number = createNumber();
        String firstNumber = "BB-1998-0";
        String licenseSerial = number.getLicenseNumber();
        Assert.assertTrue(licenseSerial.equals(firstNumber));
    }

    //Helpers for object creation
    private String initials = "BB";
    private int issueYear = 1998;

    private LicenceNumber createNumber() {
        return new LicenceNumber(initials, issueYear);
    }

}
