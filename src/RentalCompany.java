import java.util.*;

/**
 * Class represents top level functions of rental company. Fields and methods
 * concerned with managing car rentals, including issuing, returning, finding out
 * the number of available cars etc.
 */
public final class RentalCompany {

    //protected static for access by tests
    protected static final int MAX_LARGE_CAR = 20;
    protected static final int MAX_SMALL_CAR = 30;

    //Collections for cars
    private Map<DrivingLicence, Car> currentRentals;
    Queue<Car> smallCars;
    Queue<Car> largeCars;

    private RentalCompany() {
        this.currentRentals = new HashMap<>();
        this.smallCars = new LinkedList<>(carListGenerator("small", MAX_SMALL_CAR));
        this.largeCars = new LinkedList<>(carListGenerator("large", MAX_LARGE_CAR));
    }

    public static RentalCompany getInstance() {
        return new RentalCompany();
    }

    //Helper to populate car lists
    private static LinkedList<Car> carListGenerator(String typeOfCar, int numberOfCars) {
        LinkedList<Car> carList = new LinkedList<>();
        for(int i = 0; i < numberOfCars; i++) {
            carList.add(CarFactory.getInstance(typeOfCar));
        }
        return carList;
    }

    /**
     * Returns the number of available cars depending
     * on the name of the type of car passed in.
     * @param typeOfCar "small" or "large"
     * @return The number of cars remaining of each time, or -1 for unknown input.
     */
    public int availableCars(String typeOfCar) {
        if (typeOfCar == "large") {
            return largeCars.size();
        } else if (typeOfCar == "small") {
            return smallCars.size();
        } else {
            return -1;
        }
    }

    /**
     * Returns all rented cars.
     * @return A collection of Car
     */
    public Collection<Car> getRentedCars() {
        return this.currentRentals.values();
    }

    /**
     * Returns the car associated with the licence, or null if no rental exists.
     * @param licence A driver's licence
     * @return A car or null.
     */
    public Car getCar(DrivingLicence licence) {
        return currentRentals.get(licence);
    }

    /**
     * Issues a car under the following circumstances:
     * - Person renting the car must have a full driving licence.
     * - They cannot rent more than one car at a time.
     * - To rent a Small car, they must be at least 21 years old and must have held their licence
     * for at least 1 year.
     * - To rent a Large car, they must be at least 25 years old and must have held their licence
     * for at least 5 years
     * Car is removed from List, set as rented, and put into the current rentals.
     * Returns true for success, false if car was not issued.
     * @param licence A driver's licence.
     * @param typeOfCar "small" or "large.
     * @return True for success, false for no car issued.
     */
    public boolean issueCar(DrivingLicence licence, String typeOfCar) {
        if (!licence.isFullLicense() || this.getCar(licence) != null) return false;
        if (typeOfCar.equals("small") && eligibleForSmall(licence) && !smallCars.isEmpty()) {
            Car car = smallCars.poll();
            return finaliseRental(licence, car);
        }
        if (typeOfCar.equals("large") && eligibleForLarge(licence) && !largeCars.isEmpty()) {
            Car car = largeCars.poll();
            return finaliseRental(licence, car);
        }
        return false;
    }

    /**
     * This method terminates the rental contract associated with the given driving licence.
     * The car is then returned to its respective list. If the tank was not full, the amount
     * of fuel needed to refill the car is returned. The car is refilled at this point to be
     * ready for future rentals.
     * @param licence A driver's licence.
     * @return A number representing the amount of fuel that was required to refill the tank.
     */
    public int terminateRental(DrivingLicence licence) {
        Car rental = currentRentals.get(licence);
        if (rental == null) return 0;
        if (rental instanceof SmallCar) {
            return finaliseTermination(licence, rental, smallCars);
        }
        if (rental instanceof LargeCar) {
            return finaliseTermination(licence, rental, largeCars);
        }
        return 0;
    }

    //Helper Methods for readability of main methods & modularity

    /**
     * Helper for determining eligibility for small car rental.
     * Driver must be at least 21, and have had their licence for at least 1 year.
     * @param licence A driver's licence.
     * @return True if eligible, false if not.
     */
    private boolean eligibleForSmall(DrivingLicence licence) {
        Date today = new Date();
        return (DrivingLicence.differenceInYears(licence.getDateOfBirth(), today) >= 21) &&
               (DrivingLicence.differenceInYears(licence.getIssueDate(), today) >= 1);
    }

    /**
     * Helper for determining eligibility for large car rental.
     * Driver must be at least 25, and have had their licence for at least 5 year.
     * @param licence A driver's licence.
     * @return True if eligible, false if not.
     */
    private boolean eligibleForLarge(DrivingLicence licence) {
        Date today = new Date();
        return (DrivingLicence.differenceInYears(licence.getDateOfBirth(), today) >= 25) &&
               (DrivingLicence.differenceInYears(licence.getIssueDate(), today) >= 5);
    }

    /**
     * Processes a rental. Sets the cars rental status to true,
     * and puts it into the currentRentals list.
     * @param licence A driver's licence
     * @param car A car
     * @return True if processed successfully, false if some objects are null.
     */
    private boolean finaliseRental(DrivingLicence licence, Car car) {
        if (car == null || licence == null) return false;
        car.setRentalStatus(true);
        currentRentals.put(licence, car);
        return true;
    }

    /**
     * Processes a return. Sets the cars rental status to false,
     * and puts it into the relevant car list.
     * @param licence A driver's licence
     * @param car A car
     * @param carList A collection of Car
     * @return True if processed successfully, false if some objects are null.
     */
    private int finaliseTermination(DrivingLicence licence, Car car, Queue<Car> carList) {
        if (car == null || licence == null || carList == null) return 0;
        currentRentals.remove(licence, car);
        int refillAmount = fillAndReturnAmount(car);
        car.setRentalStatus(false);
        carList.add(car);
        return refillAmount;
    }

    /**
     * Helper for filling a car upon return. If necessary, fills the car and returns the amount
     * that was needed to fill.
     * @param car A car
     * @return The amount of fuel needed to fill it.
     */
    private int fillAndReturnAmount(Car car) {
        if (car.isFull()) return 0;
        int fuelRemaining = car.getFuelRemaining();
        int capacity = car.getCapacity();
        if (fuelRemaining < 0) {
            return car.addFuel(capacity + Math.abs(fuelRemaining));
        }
        return car.addFuel(capacity - fuelRemaining);
    }

}
