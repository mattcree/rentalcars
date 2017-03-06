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
    public void driveMethodShouldReturnInt() {
        Car car = createSmallCar();
        int distance = 101;
        int expectedFuelConsumed = 6;
        System.out.println(car.drive(distance));
        Assert.assertTrue(car.drive(distance) == expectedFuelConsumed);
    }

    //Test helpers for object creation
    private Car createSmallCar() {
        return new SmallCar();
    }

}
