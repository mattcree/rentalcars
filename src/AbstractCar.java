/**
 * Created by Cree on 26/02/2017.
 */
public abstract class AbstractCar implements Car {

    private RegistrationNumber registrationNumber;
    protected boolean currentlyRented;
    protected int fuelAmount;
    protected int tankCapacity;

    public AbstractCar(int tankCapacity, int consumptionRate) {
        this.registrationNumber = RegistrationNumber.getInstance();
        this.currentlyRented = false;
        this.fuelAmount = tankCapacity;
        this.tankCapacity = tankCapacity;
    }

    public RegistrationNumber getRegNumber() {
        return registrationNumber;
    }

    public int getCapacity() {
        return tankCapacity;
    };

    public int getFuelRemaining() {
        return fuelAmount;
    };

    public boolean isFull() {
        return (tankCapacity == fuelAmount);
    };

    public boolean isCurrentlyRented() {
        return currentlyRented;
    }

    public void addFuel(int amount) {
        this.fuelAmount = this.fuelAmount + amount;
    };

    public abstract int drive(int distanceInKM);

    protected static int consumptionCalculator(int distance, int consumptionRate) {
        return distance / consumptionRate + (distance % consumptionRate == 0 ? 0 : 1);
    };

}
