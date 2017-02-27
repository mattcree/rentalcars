/**
 * Created by Cree on 26/02/2017.
 */
public enum TankCapacity {
    SMALL_CAR(49), LARGE_CAR(60);

    private final int value;

    TankCapacity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
