import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Queue;

/**
 * Created by Cree on 07/03/2017.
 */
public class RentalCompanyTest {

    @After
    public void tidy() {

    }


    @Test
    public void getInstanceShouldReturnInstanceOfRentalClass() {
        RentalCompany company = RentalCompany.getInstance();
        Assert.assertNotNull(company);
    }

    @Test
    public void getRentedCarsShouldReturnEmptyCollectionWhenNoCarsRented() {
        RentalCompany company = RentalCompany.getInstance();
        Assert.assertTrue(company.getRentedCars().isEmpty());
    }

    @Test
    public void availableCarsShouldReturnAmountOfSmallCars() {
        RentalCompany company = RentalCompany.getInstance();
        Assert.assertTrue(company.availableCars("small") == RentalCompany.MAX_SMALL_CAR);
    }

    @Test
    public void availableCarsShouldReturnAmountOfLargeCars() {
        RentalCompany company = RentalCompany.getInstance();
        Assert.assertTrue(company.availableCars("large") == RentalCompany.MAX_LARGE_CAR);
    }

    @Test
    public void availableCarsShouldReturnMinus1ForAllUnknownInput() {
        RentalCompany company = RentalCompany.getInstance();
        Assert.assertTrue(company.availableCars("bob") == -1);
    }

    @Test
    public void getCarShouldReturnNullIfNoCarRented() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        Date dob = new Date();
        Date issueDate = new Date();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        Assert.assertNull(company.getCar(licence));
    }

    @Test
    public void issueCarShouldNotIssueSmallCarWhenFullLicenceAndOver21ButHasLicenceLessThanYear() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2017,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        Assert.assertTrue(company.getRentedCars().isEmpty());
    }

    @Test
    public void issueCarShouldNotIssueSmallCarWhenFullLicenceAndAndLicenceMoreThanYearButUnder21() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1998,1,1);
        Date dob = calendar.getTime();
        calendar.set(2015,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        Assert.assertTrue(company.getRentedCars().isEmpty());
    }

    @Test
    public void issueCarShouldNotIssueSmallCarWhenNotFullLicenceOver21AndLicenceMoreThanOneYear() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2015,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, false);
        company.issueCar(licence, "small");
        Assert.assertTrue(company.getRentedCars().isEmpty());
    }

    @Test
    public void issueCarShouldIssueSmallCarIfFullLicenceOver21AndLicenceOverOneYear() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2015,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        System.out.println(company.getRentedCars());
        Assert.assertTrue(!company.getRentedCars().isEmpty());
    }

    @Test
    public void issueCarShouldNotIssueLargeCarWhenFullLicenceAndOver25ButHasLicenceLessThanFiveYears() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2015,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "large");
        Assert.assertTrue(company.getRentedCars().isEmpty());
    }

    @Test
    public void issueCarShouldNotIssueLargeCarWhenFullLicenceAndAndLicenceMoreThanFiveYearsButUnder25() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1994,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "large");
        Assert.assertTrue(company.getRentedCars().isEmpty());
    }

    @Test
    public void issueCarShouldNotIssueLargeCarWhenNotFullLicenceOver25AndLicenceMoreThanFiveYear() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, false);
        company.issueCar(licence, "large");
        Assert.assertTrue(company.getRentedCars().isEmpty());
    }

    @Test
    public void issueCarShouldIssueLargeCarIfFullLicenceOver25AndLicenceOverFiveYear() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "large");
        System.out.println(company.getRentedCars());
        Assert.assertTrue(!company.getRentedCars().isEmpty());
    }


    @Test
    public void issueCarShouldNotIssueSecondCarToSameLicence() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        company.issueCar(licence, "small");
        System.out.println(company.getRentedCars());
        Assert.assertTrue(company.getRentedCars().size() == 1);
    }

    @Test
    public void issueCarShouldNotIssueSecondCarToSameLicenceEvenIfCarsDifferentType() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        company.issueCar(licence, "large");
        System.out.println(company.getRentedCars());
        Assert.assertTrue(company.getRentedCars().size() == 1);
    }

    @Test
    public void issueCarShouldIssueSecondCarToSecondLicence() {
        RentalCompany company = RentalCompany.getInstance();

        Name name = new Name("John", "Doe");

        calendar.set(1980,1,1);
        Date dob1 = calendar.getTime();
        calendar.set(2015,1,1);
        Date issueDate1 = calendar.getTime();

        calendar.set(1980,1,1);
        Date dob2 = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate2 = calendar.getTime();

        DrivingLicence licence1 = new DrivingLicence(name, dob1, issueDate1, true);
        DrivingLicence licence2 = new DrivingLicence(name, dob2, issueDate2, true);
        company.issueCar(licence1, "small");
        company.issueCar(licence2, "large");
        System.out.println(company.getRentedCars());
        Assert.assertTrue(company.getRentedCars().size() == 2);
    }

    @Test
    public void issueCarShouldRemoveSmallCarFromSmallCarList() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        System.out.println(company.getRentedCars());
        Assert.assertTrue(company.availableCars("small") == RentalCompany.MAX_SMALL_CAR -1);
    }

    @Test
    public void issueCarShouldRemoveLargeCarFromLargeCarList() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "large");
        System.out.println(company.getRentedCars());
        Assert.assertTrue(company.availableCars("large") == RentalCompany.MAX_LARGE_CAR -1);
    }

    @Test
    public void getCarShouldReturnNullIfNoCurrentlyRentedCar() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        Assert.assertNull(company.getCar(licence));
    }

    @Test
    public void getCarShouldReturnCurrentlyRentedCar() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        Assert.assertNotNull(company.getCar(licence));
    }

    @Test
    public void issueCarShouldChangeSmallCarRentalStatusToRented() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        Assert.assertTrue(company.getCar(licence).isRented());
    }

    @Test
    public void issueCarShouldChangeLargeCarRentalStatusToRented() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "large");
        Assert.assertTrue(company.getCar(licence).isRented());
    }

    @Test
    public void terminateRentalShouldRemoveRentalFromCurrentRentals() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        company.terminateRental(licence);
        Assert.assertTrue(company.getRentedCars().isEmpty());
    }

    @Test
    public void terminateRentalShouldRemoveRentalFromCurrentRentalsAndSetRentalStatusToFalse() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        Car issuedCar = company.getCar(licence);
        company.terminateRental(licence);
        Assert.assertTrue(!issuedCar.isRented());
    }

    @Test
    public void terminateRentalShouldReturnZeroIfTankWasFull() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        Car issuedCar = company.getCar(licence);
        Assert.assertTrue(company.terminateRental(licence) == 0);
    }

    @Test
    public void terminateRentalShouldFillTankIfTankWasNotFullAndReturnAmount() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        Car issuedCar = company.getCar(licence);
        issuedCar.drive(40);
        company.terminateRental(licence);
        Assert.assertTrue(issuedCar.isFull());
    }

    @Test
    public void terminateRentalShouldReturnNumberOfLitresToFillIfTankWasNotFull() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        Car issuedCar = company.getCar(licence);
        issuedCar.drive(40);
        Assert.assertTrue(company.terminateRental(licence) == 2);
    }

    @Test
    public void terminateRentalShouldReturnNumberOfLitresToFillIfTankWasLessThanZero() {
        RentalCompany company = RentalCompany.getInstance();
        Name name = new Name("John", "Doe");
        calendar.set(1980,1,1);
        Date dob = calendar.getTime();
        calendar.set(2010,1,1);
        Date issueDate = calendar.getTime();
        DrivingLicence licence = new DrivingLicence(name, dob, issueDate, true);
        company.issueCar(licence, "small");
        Car issuedCar = company.getCar(licence);
        issuedCar.drive((issuedCar.getCapacity() + 1) * 20);
        Assert.assertTrue(company.terminateRental(licence) == 50);
    }

    private Calendar calendar = Calendar.getInstance();

}
