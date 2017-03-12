/**
 * Interface containing all the public behavior that any Car which uses
 * it should implement.
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
