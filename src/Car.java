/**
 * Created by Cree on 27/02/2017.
 */
public interface Car {
    public RegistrationNumber getRegNumber();
    public int getCapacity();
    public int getFuelRemaining();
    public boolean isFull();
    public boolean isRented();
    public void setRentalStatus(boolean status);
    public int addFuel(int amount);
    public int drive(int distance);
}
