/**
 * The AbstractCar implements the Car interface and implements all the common
 * fields and behavior shared by all cars. The drive method remains abstract,
 * as it requires unique implementations based on different fuel consumption rates.
 */
public abstract class AbstractCar implements Car {

    private RegistrationNumber registrationNumber;
    protected boolean isRented;
    protected int fuelAmount;
    protected int tankCapacity;

    /**
     * Constructor for AbstractCar. TankCapacity and a rate of consumption
     * are required fields. New Cars default to having a full tank, are not
     * rented, and have a unique registration number assigned upon creation.
     * @param tankCapacity A tank capacity in litres
     * @param consumptionRate Rate that the car consumes fuel at (KM/L)
     */
    public AbstractCar(int tankCapacity, int consumptionRate) {
        this.registrationNumber = RegistrationNumber.getInstance();
        this.isRented = false;
        this.fuelAmount = tankCapacity;
        this.tankCapacity = tankCapacity;
    }

    /**
     * Returns a car's registration number.
     * @return A RegistrationNumber object.
     */
    public RegistrationNumber getRegNumber() {
        return this.registrationNumber;
    }

    /**
     * Returns the car's tank capacity.
     * @return A number representing the capacity of a car's tank.
     */
    public int getCapacity() {
        return this.tankCapacity;
    }

    /**
     * Returns the fuel remaining in the car's tank.
     * @return A number representing how much fuel is still left in the tank.
     */
    public int getFuelRemaining() {
        return this.fuelAmount;
    }

    /**
     * Returns true if the tank is full, i.e. if the tank capacity is
     * equal to the amount of fuel in the tank.
     * @return True if full, false if not full.
     */
    public boolean isFull() {
        return (this.tankCapacity == this.fuelAmount);
    }

    /**
     * Returns true if the car is currently rented. Set to false by default.
     * @return True if rented, false if not rented.
     */
    public boolean isRented() {
        return this.isRented;
    }

    /**
     * A set method for rental status.
     * @param status True to set the car as rented, false to set as not rented.
     */
    public void setRentalStatus(boolean status) {
        this.isRented = status;
    }

    /**
     * Allows the car's fuel to be refilled. Only allows the tank to be filled
     * if the car is not full, and not rented (car's tank should be filled upon
     * being returned, so should be full if set to not rented).
     * @param fuelToAdd The amount of fuel to be added to the tank.
     * @return The amount of fuel actually added i.e. if the tank was almost full
     * it will return the amount that could actually be added.
     */
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

    /**
     * Abstract method to be implemented by concrete subclasses.
     * Should check that tank isn't empty, car is rented.
     * Fuel must decrement based on distance and fuel
     * consumption rate. Fuel consumed, rounded up to nearest
     * whole number should be returned.
     * @param distanceInKM The distance to drive.
     * @return The fuel consumed.
     */
    public abstract int drive(int distanceInKM);

    /**
     * Static function to help with fuel consumption calculations.
     * Rounds up to the nearest liter i.e. if 4.3 litres
     * of fuel is used, it will return 5.
     * @param distance The distance in KM
     * @param consumptionRate The rate of consumption in KM/L
     * @return A whole number representing the amount of liters used.
     */
    protected static int consumptionCalc(int distance, int consumptionRate) {
        //This way of rounding-up avoids inaccuracies with floating point numbers
        //and eliminates the need for multiple casts of ints to doubles.
        return distance / consumptionRate + (distance % consumptionRate == 0 ? 0 : 1);
    }

}
