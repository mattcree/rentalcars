/**
 * Created by Cree on 24/02/2017.
 */
public class SmallCar extends CommonCar {

    private static final int TANK_CAPACITY = 49;

    public SmallCar(){
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
