/**
 * Created by Cree on 24/02/2017.
 */
public class SmallCar extends AbstractCar {

    private static final int TANK_CAPACITY = 49;
    private static final int CONSUMPTION_RATE = 20;

    public SmallCar(){
        super(TANK_CAPACITY, CONSUMPTION_RATE);
    }

    public int drive(int distanceInKM) {
        if (this.fuelAmount > 0) {
            int fuelUsed = AbstractCar.consumptionCalc(distanceInKM, CONSUMPTION_RATE);
            this.fuelAmount = this.fuelAmount - fuelUsed;
            return fuelUsed;
        }
        return -1;
    }

}
