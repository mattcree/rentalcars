import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Cree on 02/03/2017.
 */
public class LargeCarTest {

    @Test
    public void createSmallCarShouldCreateValidSmallCar() {
        Car car = createLargeCar();
        Assert.assertNotNull(car);
    }

    @Test
    public void driveMethodShouldReturnAmountOfFuelUsedDuringJourney() {
        Car car = createLargeCar();
        int distance = 50;
        int expectedFuelConsumed = 5;
        Assert.assertTrue(car.drive(distance) == expectedFuelConsumed);
    }

    @Test
    public void driveMethodShouldReturnRoundUpToNearestWholeLitre()   {
        Car car = createLargeCar();
        int distance = 11;
        int expectedFuelConsumed = 2;
        Assert.assertTrue(car.drive(distance) == expectedFuelConsumed);
    }

    @Test
    public void driveMethodShouldChangeConsumptionRateOverFiftyKM()   {
        Car car = createLargeCar();
        int distance = 66;
        int expectedFuelConsumed = 7;
        Assert.assertTrue(car.drive(distance) == expectedFuelConsumed);
    }

    @Test
    public void driveMethodShouldReturnMinusOneWhenTankIsEmpty() {
        Car car = createLargeCar();
        car.drive(car.getCapacity() * 60);
        Assert.assertTrue(car.drive(1) == -1);
    }

    //Test helpers for object creation
    private Car createLargeCar() {
        return new LargeCar();
    }

}
