/**
 * Created by Cree on 26/02/2017.
 */
public abstract class CommonCar implements Car {
    private RegistrationNumber registrationNumber;
    private boolean currentlyRented;
    private int fuelAmount;

    public CommonCar(int fuelAmount) {
        this.registrationNumber = RegistrationNumber.getInstance();
        this.currentlyRented = false;
        this.fuelAmount = fuelAmount;
    }

    public RegistrationNumber getRegNumber() {
        return registrationNumber;
    }

    public abstract int getCapacity();

    public int getFuelRemaining() {
        return fuelAmount;
    };

    public abstract boolean isFull();

    public boolean isCurrentlyRented() {
        return currentlyRented;
    }

    public void addFuel(int amount) {
        this.fuelAmount = this.fuelAmount + amount;
    };

    public abstract void drive(int distanceInKM);

}
