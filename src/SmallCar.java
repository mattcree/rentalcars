/**
 * SmallCar fields and behaviour. Implements unique tank
 * capacity, consumption rates, and drive method.
 */
public class SmallCar extends AbstractCar {

    private static final int TANK_CAPACITY = 49;
    private static final int CONSUMPTION_RATE = 20;

    /**
     * SmallCar constructor. Creates a new SmallCar using the static
     * values unique to SmallCar objects i.e. their tank capacity
     * and the rate(s) they consume fuel at.
     */
    protected SmallCar(){
        super(TANK_CAPACITY, CONSUMPTION_RATE);
    }

    /**
     * A drive method for SmallCars. If the tank is not empty, it will
     * decrement the fuelAmount of the car by the distanceInKM param.
     * The amount of fuel used is returned.
     * Returns -1 if the car was not driven (i.e. fuel remaining
     * was less than 1 before driving).
     * @param distanceInKM The distance to be driven
     * @return The amount of fuel used during the journey.
     */
    public int drive(int distanceInKM) {
        if (this.fuelAmount > 0) {
            int fuelUsed = AbstractCar.consumptionCalc(distanceInKM, CONSUMPTION_RATE);
            this.fuelAmount = this.fuelAmount - fuelUsed;
            return fuelUsed;
        }
        return -1;
    }

}
