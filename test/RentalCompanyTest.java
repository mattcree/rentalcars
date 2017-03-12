import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Queue;

/**
 * Created by Cree on 07/03/2017.
 */
public class RentalCompanyTest {

    @Test
    public void getInstanceShouldReturnSingletonRentalClass() {
        RentalCompany company = RentalCompany.getInstance();
        RentalCompany secondCompany = RentalCompany.getInstance();
        Assert.assertSame(company, secondCompany);
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

}
