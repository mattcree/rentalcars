/**
 * Created by Cree on 02/03/2017.
 */
public class RentalCompany {

    private static final RentalCompany COMPANY = new RentalCompany();

    private RentalCompany() {

    }

    public static RentalCompany getInstance() {
        return COMPANY;
    }

    /*private int availableCars(typeOfCar)
        returns the number of cars of the specified type that are available to rent.

    private Collection getRentedCars()
        returns a collection of all the cars currently rented out (if any)

    private Car getCar(drivingLicence)
        Given a person's driving licence, this method
        returns the car they are currently renting(if any)

    private boolean issueCar(drivingLicence, typeOfCar)
        Given
            a person's driving licence and
            a specification of the type of car required (small or large),
        this method determines whether the person is eligible to rent a car of the
        specified type and,
            if there is a car available,
                issues a car of the specified type.

        The carmust have a full tank of petrol at the start of the rental.
        The method associates the car with the person's driving licence (so that the company has a record of cars out for rent
        and the people renting them).

            If a car cannot be issued,
                the method returns an appropriate indication of the failure to issue a car.

        Note, this does not have to indicate why a car cannot be issued, it simply indicates
        that a car cannot be issued. The rules for determining whether or not a car can be issued are given below.

    private int terminateRental(drivingLicence)
        This method terminates the rental contract associated with the given driving licence.
        In effect, the driver is returning the car.
        The car is then available for rent by someone else.
        The method removes the record of the rental from the company's records (disassociating
        the car from the licence) and returns the amount of fuel in Litres required to fill the car's
        tank.
        The driver returning the car must either have returned the car with a full tank or
        will be liable for the number of Litres required to fill the tank.
        This terminateRental method is not responsible for managing charges for the required fuel.
        It just reports the amount of fuel required to fill the tank.
        This method changes the status of the returned car to not rented.
        Terminating a non-existent contract has no effect.
    */


}
