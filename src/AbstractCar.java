/**
 * Created by Cree on 26/02/2017.
 */
public abstract class AbstractCar implements Car {

    private RegistrationNumber registrationNumber;
    protected boolean isRented;
    protected int fuelAmount;
    protected int tankCapacity;

    public AbstractCar(int tankCapacity, int consumptionRate) {
        this.registrationNumber = RegistrationNumber.getInstance();
        this.isRented = false;
        this.fuelAmount = tankCapacity;
        this.tankCapacity = tankCapacity;
    }

    public RegistrationNumber getRegNumber() {
        return this.registrationNumber;
    }

    public int getCapacity() {
        return this.tankCapacity;
    };

    public int getFuelRemaining() {
        return this.fuelAmount;
    };

    public boolean isFull() {
        return (this.tankCapacity == this.fuelAmount);
    };

    public boolean isRented() {
        return this.isRented;
    }

    public void setRentalStatus(boolean status) {
        this.isRented = status;
    }

    public int addFuel(int fuelToAdd) {
        if (!this.isRented || this.isFull()) {
            return 0;
        } else if (fuelToAdd + this.fuelAmount > this.tankCapacity) {
            int amountAdded = this.tankCapacity - this.fuelAmount;
            this.fuelAmount = this.tankCapacity;
            return amountAdded;
        } else {
            this.fuelAmount = this.fuelAmount + fuelToAdd;
            return fuelToAdd;
        }
    }

    public abstract int drive(int distanceInKM);

    protected static int consumptionCalculator(int distance, int consumptionRate) {
        return distance / consumptionRate + (distance % consumptionRate == 0 ? 0 : 1);
    }

}
