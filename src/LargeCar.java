/**
 * LargeCar fields and behaviour. Implements unique tank
 * capacity, consumption rates, and drive method.
 */
public class LargeCar extends AbstractCar {

    //Static fields represent the the values required for car creation
    //which are unique to the LargeCar class. LargeCar has an extra consumption
    //rate.
    private static final int TANK_CAPACITY = 60;
    private static final int CONSUMPTION_RATE = 10;
    private static final int CONSUMPTION_RATE_AFTER_50 = 15;

    /**
     * LargeCar constructor. Creates a new LargeCar using the static
     * values unique to LargeCar objects i.e. their tank capacity
     * and the rate(s) they consume fuel at.
     */
    protected LargeCar(){
        super(TANK_CAPACITY, CONSUMPTION_RATE);
    }

    /**
     * A drive method for LargeCars. If the tank is not empty, it will
     * decrement the fuelAmount of the car by the distanceInKM param.
     * If the distance is over 50km the distance above 50km removes fuel
     * at a different rate (15km/L). The amount of fuel used is returned.
     * Returns -1 if the car was not driven (i.e. tank was  less than 1 before driving).
     * @param distanceInKM The distance to be driven (Kilometers)
     * @return The amount of fuel used during the journey (Litres)
     */
    public int drive(int distanceInKM) {
        if (this.fuelAmount <= 0) return -1;
        if (distanceInKM > 50) {
            int fuelUsed = 5 + AbstractCar.consumptionCalc(distanceInKM - 50, CONSUMPTION_RATE_AFTER_50);
            this.fuelAmount = this.fuelAmount - fuelUsed;
            return fuelUsed;
        } else {
            int fuelUsed = AbstractCar.consumptionCalc(distanceInKM, CONSUMPTION_RATE);
            this.fuelAmount = this.fuelAmount - fuelUsed;
            return fuelUsed;
        }
    }
}
