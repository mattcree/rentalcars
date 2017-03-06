import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Cree on 06/03/2017.
 */
public class AbstractCarTest {

    @Test
    public void createNewAbstractCarTestStubShouldCreateValidAbstractCarTest() {
        Car car = AbstractCarTestStub.getInstance();
        Assert.assertNotNull(car);
    }

    @Test
    public void getRegNumberShouldReturnValidRegNumber() {
        Car car = AbstractCarTestStub.getInstance();
        Assert.assertNotNull(car.getRegNumber());
    }

    @Test
    public void getCapacityReturnsTankCapacity() {
        Car car = AbstractCarTestStub.getInstance();
        Assert.assertTrue(car.getCapacity() == AbstractCarTestStub.TANK_CAPACITY);
    }

    @Test
    public void getFuelRemainingShouldReturnFullTankByDefault() {
        Car car = AbstractCarTestStub.getInstance();
        Assert.assertTrue(car.getFuelRemaining() == AbstractCarTestStub.TANK_CAPACITY);
    }

    @Test
    public void isFullShouldReturnTrueWhenFuelAmountEqualsTankCapacity() {
        Car car = AbstractCarTestStub.getInstance();
        Assert.assertTrue(car.isFull() && car.getCapacity() == car.getFuelRemaining());
    }

    @Test
    public void driveTestImplementationShouldRemoveFuel() {
        Car car = AbstractCarTestStub.getInstance();
        int amountOfFuelToRemove = 1;
        car.drive(1);
        Assert.assertTrue(car.getFuelRemaining() == car.getCapacity() - amountOfFuelToRemove);
    }

    @Test
    public void isFullShouldReturnFalseWhenTankIsNotFull() {
        Car car = AbstractCarTestStub.getInstance();
        int amountOfFuelToRemove = 1;
        car.drive(amountOfFuelToRemove);
        Assert.assertFalse(car.isFull());
    }

    @Test
    public void isRentedShouldReturnFalseByDefault() {
        Car car = AbstractCarTestStub.getInstance();
        Assert.assertFalse(car.isRented());
    }

    @Test
    public void setRentalStatusShouldSetRentalStatus() {
        Car car = AbstractCarTestStub.getInstance();
        car.setRentalStatus(true);
        Assert.assertTrue(car.isRented());
    }

    @Test
    public void addFuelShouldReturnZeroIfTankIsFull() {
        Car car = AbstractCarTestStub.getInstance();
        int amountToAdd = 1;
        Assert.assertTrue(car.addFuel(amountToAdd) == 0);
    }

    @Test
    public void addFuelShouldNotIncrementTankIfTankIsFull() {
        Car car = AbstractCarTestStub.getInstance();
        int amountToAdd = 1;
        car.addFuel(amountToAdd);
        Assert.assertTrue(car.getFuelRemaining() == car.getCapacity());
    }

    @Test
    public void addFuelShouldReturnZeroIfCarIsRentedAndFull() {
        Car car = AbstractCarTestStub.getInstance();
        int amountToAdd = 1;
        car.setRentalStatus(true);
        car.addFuel(amountToAdd);
        Assert.assertTrue(car.addFuel(amountToAdd) == 0);
    }

    @Test
    public void addFuelShouldReturnAmountOfFuelAddedIfTankIsEmpty() {
        Car car = AbstractCarTestStub.getInstance();
        int amountToRemove = 10;
        car.drive(amountToRemove);
        int amountToAdd = 5;
        car.addFuel(amountToAdd);
        Assert.assertTrue(car.getFuelRemaining()
                                    == car.getCapacity()
                                    - amountToRemove
                                    + amountToAdd);
    }


    //Test Stub to create minimal AbstractCar

    private static class AbstractCarTestStub extends AbstractCar {

        protected static final int TANK_CAPACITY = 60;
        protected static final int CONSUMPTION_RATE = 10;

        private AbstractCarTestStub() {
            super(TANK_CAPACITY, CONSUMPTION_RATE);
        }

        public static AbstractCarTestStub getInstance() {
            return new AbstractCarTestStub();
        }

        public int drive(int removeFuel) {
            //Implementing simple fuel decrementer for testing
            this.fuelAmount = this.fuelAmount - removeFuel;
            return this.fuelAmount;
        }

    }

}
