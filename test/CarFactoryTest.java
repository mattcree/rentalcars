import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Cree on 12/03/2017.
 */
public class CarFactoryTest {

    @Test
    public void carFactoryShouldReturnSmallCarWhenParamIsSmall() {
        Car car = CarFactory.getInstance("small");
        Assert.assertTrue(car instanceof SmallCar);
    }

    @Test
    public void carFactoryShouldReturnLargeCarWhenParamIsLarge() {
        Car car = CarFactory.getInstance("large");
        Assert.assertTrue(car instanceof LargeCar);
    }

    @Test
    public void carFactoryShouldReturnNullCarWhenParamNotSmallOrLarge() {
        Car car = CarFactory.getInstance("bobby");
        Assert.assertTrue(car == null);
    }


}
