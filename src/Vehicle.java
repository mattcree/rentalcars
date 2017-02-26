/**
 * Created by Cree on 26/02/2017.
 */
public interface Vehicle {
    public RegistrationNumber getRegistration();
    public int getCapacity();
    public int getFuelRemaining();
    public boolean isFull();
    public boolean isRented();
    public boolean addFuel(int amount);
    public int drive(int distance);
}
