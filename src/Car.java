/**
 * Created by Cree on 27/02/2017.
 */
public interface Car {
    public RegistrationNumber getRegNumber();
    public int getCapacity();
    public int getFuelRemaining();
    public boolean isFull();
    public boolean isRented();
    public boolean addFuel(int amount);
    public int drive(int distance);
}
