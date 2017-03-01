import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Cree on 27/02/2017.
 */
public class LicenseNumberTest {
    @Test
    public void createNewLicenseNumberShouldCreateValidLicenseNumber() {
        LicenseNumber.setSerial(0);
        LicenseNumber number = createNumber();
        Assert.assertNotNull(number);
    }

    @Test
    public void getInitialsShouldReturnInitials() {
        LicenseNumber.setSerial(0);
        LicenseNumber number = createNumber();
        Assert.assertTrue(number.getInitials().equals(initials));
    }

    @Test
    public void getIssueYearShouldReturnYear() {
        LicenseNumber.setSerial(0);
        LicenseNumber number = createNumber();
        Assert.assertTrue(number.getIssueYear() == issueYear);
    }

    @Test
    public void getSerialShouldReturnSerialNumber() {
        LicenseNumber.setSerial(0);
        LicenseNumber number = createNumber();
        Assert.assertTrue(number.getSerial() == 0);
    }

    @Test
    public void getSerialShouldIncrementSerialUponEachNewInstance() {
        LicenseNumber.setSerial(0);
        LicenseNumber number1 = createNumber();
        LicenseNumber number2 = createNumber();
        Assert.assertTrue(number2.getSerial() == 1);
    }

    @Test
    public void getLicenseNumberShouldReturnFullLicenseNumberAsString() {
        LicenseNumber.setSerial(0);
        LicenseNumber number = createNumber();
        String firstNumber = "BB-1998-0";
        String licenseSerial = number.getLicenseNumber();
        Assert.assertTrue(licenseSerial.equals(firstNumber));
    }

    //Helpers for object creation
    private String initials = "BB";
    private int issueYear = 1998;

    private LicenseNumber createNumber() {
        return new LicenseNumber(initials, issueYear);
    }

}
