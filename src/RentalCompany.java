import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Cree on 02/03/2017.
 */
public class RentalCompany {

    private static final RentalCompany COMPANY = new RentalCompany();
    private static final int NUMBER_OF_SMALL_CAR = 30;
    private static final int NUMBER_OF_LARGE_CAR = 20;

    private Map<DrivingLicence, Car> currentRentals;
    private Queue<Car> smallCars;
    private Queue<Car> largeCars;

    private RentalCompany() {
        this.currentRentals = new HashMap<>();
        this.smallCars = new LinkedList<>(carListGenerator("small", NUMBER_OF_SMALL_CAR));
        this.largeCars = new LinkedList<>(carListGenerator("large", NUMBER_OF_LARGE_CAR));
    }

    public static RentalCompany getInstance() {
        return COMPANY;
    }

    protected static LinkedList<Car> carListGenerator(String typeOfCar, int numberOfCars) {
        LinkedList<Car> carList = new LinkedList<>();
        for(int i = 0; i < numberOfCars; i++) {
            carList.add(CarFactory.getInstance(typeOfCar));
        }
        return carList;
    }



    public int availableCars(String typeOfCar) {
        return 0;
    }

    //returns a collection of all the cars currently rented out (if any)
    public HashMap<DrivingLicence, Car> getRentedCars() {
        return new HashMap<>();
    }


    public Car getCar(DrivingLicence licence) {
        return new SmallCar();
    }
        /*Given a person's driving licence, this method
        returns the car they are currently renting(if any)
*/

    public boolean issueCar(DrivingLicence Licence, String typeOfCar) {
        return true;
    }
        /*Given
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
        that a car cannot be issued. The rules for determining whether or not a car can be issued are given below.*/

    public int terminateRental(DrivingLicence licence) {
        return 0;
    }
    /*
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
