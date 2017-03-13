/**
 * Interface containing all the public behavior that any Car which uses
 * it should implement.
 */
public interface Car {
    /**
     * Returns a registration number
     * @return A car's registration number
     */
    public RegistrationNumber getRegNumber();

    /**
     * Returns a fuel tank capacity (Litres)
     * @return A tank capacity
     */
    public int getCapacity();

    /**
     * Returns remaining fuel in tank (Litres)
     * @return Remaining fuel
     */
    public int getFuelRemaining();

    /**
     * Returns whether tank is full
     * @return True if full, false if not full
     */
    public boolean isFull();

    /**
     * Returns if car is rented
     * @return True if rented, false if not rented.
     */
    public boolean isRented();

    /**
     * Adds fuel to fuel tank (Litres)
     * @param amount Amount of fuel to add (Litres)
     * @return Amount of fuel actually added (Litres)
     */
    public int addFuel(int amount);

    /**
     * Drives the car. Removes fuel.
     * @param distance Distance to drive in (Kilometers)
     * @return Amount of fuel used (Litres)
     */
    public int drive(int distance);

    /**
     * Sets whether car is rented or not.
     * @param rentalStatus True for rented, false for not rented.
     */
    public void setRentalStatus(boolean rentalStatus);

}
