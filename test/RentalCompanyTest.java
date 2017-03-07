import org.junit.Assert;
import org.junit.Test;

import java.util.Queue;

/**
 * Created by Cree on 07/03/2017.
 */
public class RentalCompanyTest {

    @Test
    public void carListGeneratorShouldReturnValidCollectionOfCars() {
        Queue<Car> carList = RentalCompany.carListGenerator("small", 10);
        System.out.println(carList.toString());
        Assert.assertNotNull(carList);
    }
}
