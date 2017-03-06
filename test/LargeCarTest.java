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
    public void driveMethodShouldReturnInt() {
        Car car = createLargeCar();
        int distance = 66;
        int expectedFuelConsumed = 7;
        System.out.println(car.drive(distance));
        Assert.assertTrue(car.drive(distance) == expectedFuelConsumed);
    }

    //Test helpers for object creation
    private Car createLargeCar() {
        return new LargeCar();
    }

}
