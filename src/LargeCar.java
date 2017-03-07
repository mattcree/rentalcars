/**
 * Created by Cree on 24/02/2017.
 */
public class LargeCar extends AbstractCar {

    private static final int TANK_CAPACITY = 60;
    private static final int CONSUMPTION_RATE = 10;
    private static final int CONSUMPTION_RATE_AFTER_50 = 15;

    public LargeCar(){
        super(TANK_CAPACITY, CONSUMPTION_RATE);
    }

    public int drive(int distanceInKM) {
        if (this.fuelAmount > 0) {
            if (distanceInKM > 50) {
                int fuelUsed = 5 + AbstractCar.consumptionCalc(distanceInKM - 50,
                                                                     CONSUMPTION_RATE_AFTER_50);
                this.fuelAmount = this.fuelAmount - fuelUsed;
                return fuelUsed;
            } else {
                int fuelUsed = AbstractCar.consumptionCalc(distanceInKM, CONSUMPTION_RATE);
                this.fuelAmount = this.fuelAmount - fuelUsed;
                return fuelUsed;
            }
        }
        return -1;
    };
}
