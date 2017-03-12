import org.junit.Assert;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Cree on 01/03/2017.
 */
public class DrivingLicenceTest {

    @Test
    public void createNewDrivingLicenceShouldCreateValidDrivingLicence() {
        DrivingLicence licence = createLicence(1987, 1, 8,1987, 1, 8, false);
        Assert.assertNotNull(licence);
    }

    @Test
    public void getNameShouldReturnValidName() {
        DrivingLicence licence = createLicence(1987, 1, 8,1987, 1, 8, false);
        Assert.assertTrue(licence.getName().equals(name));
    }

    @Test
    public void getDateOfBirthShouldReturnValidDateOfBirth() {
        DrivingLicence licence = createLicence(1987, 1, 8,1987, 1, 8, false);
        Assert.assertNotNull(licence.getDateOfBirth());
    }

    @Test
    public void getDateOfBirthShouldReturnCopyOfDateOfBirth() {
        Calendar calendar = Calendar.getInstance();
        int year = 1998;
        int month = 12;
        int day = 3;
        Name name = new Name("Barry", "Bant");
        calendar.set(year, month, day);
        Date dob = calendar.getTime();
        Date issueDate = calendar.getTime();

        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, false);
        Date compareDate = licence.getDateOfBirth();

        Assert.assertNotSame(dob, compareDate);
    }

    @Test
    public void getIssueDateShouldReturnValidIssueDate() {
        DrivingLicence licence = createLicence(1987, 1, 8,1987, 1, 8, true);
        Assert.assertNotNull(licence.getIssueDate());
    }


    @Test
    public void isFullLicenceShouldReturnLicenseStatus() {
        DrivingLicence licence = createLicence(1987, 1, 8,1987, 1, 8, true);
        Assert.assertTrue(licence.isFullLicense());
    }

    @Test
    public void getLicenceNumberShouldReturnLicenceNumber() {
        DrivingLicence licence = createLicence(1998, 12, 3,1987, 1, 8, true);
        Assert.assertNotNull(licence.getLicenceNumber());
    }

    @Test
    public void equalsShouldReturnTrueIfParamIsSameObject() {
        DrivingLicence licence = createLicence(1987, 1, 8,1987, 1, 8, true);
        DrivingLicence sameLicence = licence;
        Assert.assertTrue(licence.equals(sameLicence));
    }

    @Test
    public void equalsShouldReturnFalseIfParamIsNotSameObject() {
        DrivingLicence licence = createLicence(1987, 1, 8,1987, 1, 8, true);
        DrivingLicence secondLicenceSameInfo = createLicence(1987, 1, 8,1987, 1, 8, true);
        Assert.assertFalse(licence.equals(secondLicenceSameInfo));
    }

    @Test
    public void equalsShouldReturnFalseIfParamIsNotSameType() {
        DrivingLicence licence = createLicence(1987, 1, 8,1987, 1, 8, true);
        Name barry = new Name("Barry", "Bant");
        Assert.assertFalse(licence.equals(barry));
    }

    @Test
    public void hashCodeShouldReturnLicenceNumbersHashcode() {
        DrivingLicence licence = createLicence(1987, 1, 8,1987, 1, 8, true);
        Assert.assertEquals(licence.getLicenceNumber().hashCode(), licence.hashCode());
    }

    @Test
    public void ageCalculatorShouldReturnTimeDifferenceBetweenTwoDates() {
        DrivingLicence licence = createLicence(1987, 1, 8,1998, 1, 8, true);
        Date dob = licence.getDateOfBirth();
        Date today = new Date();

        System.out.println(DrivingLicence.differenceInYears(dob, today));
        Assert.assertTrue(DrivingLicence.differenceInYears(dob, today) == 30);
    }

    @Test
    public void ageCalculatorShouldReturnZeroIfLessThanYearBetweenDates() {
        DrivingLicence licence = createLicence(2015, 3, 12,2016, 3, 11, true);
        Date dob = licence.getDateOfBirth();
        Date issueDate = licence.getIssueDate();
        Assert.assertTrue(DrivingLicence.differenceInYears(dob, issueDate) == 0);
    }

    //Helpers for object creation
    private Name name = new Name("Barry", "Bant");
    private Calendar dateOfBirth = new GregorianCalendar();
    private Calendar issueDate = new GregorianCalendar();

    public DrivingLicence createLicence(int year, int month, int day, int year2, int month2, int day2, boolean licenseStatus) {
        dateOfBirth.set(Calendar.YEAR, year);
        dateOfBirth.set(Calendar.MONTH, month);
        dateOfBirth.set(Calendar.DAY_OF_MONTH, day);

        issueDate.set(Calendar.YEAR, year2);
        issueDate.set(Calendar.MONTH, month2);
        issueDate.set(Calendar.DAY_OF_MONTH, day2);

        return new DrivingLicence(name, dateOfBirth.getTime(), issueDate.getTime(), licenseStatus);

    }

}
