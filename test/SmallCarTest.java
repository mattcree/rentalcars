import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Cree on 02/03/2017.
 */
public class SmallCarTest {

    @Test
    public void createSmallCarShouldCreateValidSmallCar() {
        Car car = createSmallCar();
        Assert.assertNotNull(car);
    }

    @Test
    public void driveMethodShouldReturnAmountOfFuelUsedDuringJourney()   {
        Car car = createSmallCar();
        int distance = 20;
        int expectedFuelConsumed = 1;
        Assert.assertTrue(car.drive(distance) == expectedFuelConsumed);
    }

    @Test
    public void driveMethodShouldReturnRoundUpToNearestWholeLitre()   {
        Car car = createSmallCar();
        int distance = 21;
        int expectedFuelConsumed = 2;
        Assert.assertTrue(car.drive(distance) == expectedFuelConsumed);
    }

    @Test
    public void driveMethodShouldReturnZeroWhenTankIsEmpty() {
        Car car = createSmallCar();
        car.drive(car.getCapacity() * 49);
        Assert.assertTrue(car.drive(5) == -1);
    }

    //Test helpers for object creation
    private Car createSmallCar() {
        return new SmallCar();
    }

}
