/**
 * Created by Cree on 24/02/2017.
 */
public class LargeCar extends CommonCar {

    private static final int TANK_CAPACITY = 60;

    public LargeCar(){
        super(TANK_CAPACITY);
    }

    public int getCapacity() {
        return TANK_CAPACITY;
    };

    public boolean isFull() {
        return (super.getFuelRemaining() == TANK_CAPACITY);
    };

    public void drive(int distanceInKM) {

    };

}
