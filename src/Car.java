/**
 * Created by Cree on 26/02/2017.
 */
public abstract class Car {

    private RegistrationNumber registrationNumber;
    private int fuelRemaining;
    private boolean rentalStatus;

    public RegistrationNumber getRegistration();
    public int getCapacity();
    public int getFuelRemaining();
    public boolean isFull();
    public boolean isRented();
    public boolean addFuel(int amount);


}
