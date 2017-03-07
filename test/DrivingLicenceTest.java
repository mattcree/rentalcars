import org.junit.Assert;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Cree on 01/03/2017.
 */
public class DrivingLicenceTest {

    @Test
    public void createNewDrivingLicenceShouldCreateValidDrivingLicence() {
        DrivingLicence licence = createLicence(1987, 1, 8, false);
        Assert.assertNotNull(licence);
    }

    @Test
    public void getNameShouldReturnValidName() {
        DrivingLicence licence = createLicence(1987, 1, 8, false);
        Assert.assertTrue(licence.getName().equals(name));
    }

    @Test
    public void getDateOfBirthShouldReturnValidDateOfBirth() {
        DrivingLicence licence = createLicence(1987, 1, 8, false);
        Assert.assertNotNull(licence.getDateOfBirth());
    }

    @Test
    public void isFullLicenceShouldReturnLicenseStatus() {
        DrivingLicence licence = createLicence(1987, 1, 8, true);
        Assert.assertTrue(licence.isFullLicense());
    }

    //Helpers for object creation
    private Name name = new Name("Barry", "Bant");
    private Calendar dateOfBirth = new GregorianCalendar();

    public DrivingLicence createLicence(int year, int month, int day, boolean licenseStatus) {
        dateOfBirth.set(Calendar.YEAR, year);
        dateOfBirth.set(Calendar.MONTH, month);
        dateOfBirth.set(Calendar.DAY_OF_MONTH, day);

        return new DrivingLicence(name, dateOfBirth.getTime(), licenseStatus);

    }

}
