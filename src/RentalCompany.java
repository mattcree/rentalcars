import java.util.*;

/**
 * Created by Cree on 02/03/2017.
 */
public final class RentalCompany {

    protected static final int MAX_LARGE_CAR = 20;
    protected static final int MAX_SMALL_CAR = 30;

    private Map<DrivingLicence, Car> currentRentals;

    Queue<Car> smallCars;
    Queue<Car> largeCars;

    private RentalCompany() {
        this.currentRentals = new HashMap<>();
        smallCars = new LinkedList<>(carListGenerator("small", MAX_SMALL_CAR));
        largeCars = new LinkedList<>(carListGenerator("large", MAX_LARGE_CAR));
    }

    public static RentalCompany getInstance() {
        return new RentalCompany();
    }

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
     * - person renting the car must have a full driving licence
     * - they cannot rent more than one car at a time
     *- to rent a small car, they must be at least 21 years old and must have held their licence
     * for at least 1 year
     * -to rent a large car, they must be at least 25 years old and must have held their licence
     * for at least 5 years
     * Car is removed from List, set as rented, and put into the current rentals.
     * Returns true for success, false if car was not issued.
     * @param licence A driver's licence
     * @param typeOfCar "small" or "large
     * @return True for success, false for no car issued.
     */
    public boolean issueCar(DrivingLicence licence, String typeOfCar) {
        if (!licence.isFullLicense() || this.getCar(licence) != null) return false;
        if (typeOfCar.equals("small") && eligibleForSmall(licence) && !smallCars.isEmpty()) {
            Car car = smallCars.poll();
            car.setRentalStatus(true);
            currentRentals.put(licence, car);
            return true;
        }
        if (typeOfCar.equals("large") && eligibleForLarge(licence) && !largeCars.isEmpty()) {
            Car car = largeCars.poll();
            car.setRentalStatus(true);
            currentRentals.put(licence, car);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Helper for determining eligibility for small car rental eligibility.
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
     * Helper for determining eligibility for large car rental eligibility.
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
     *
     * @param licence
     * @return
     */
    public int terminateRental(DrivingLicence licence) {
        Car rental = currentRentals.get(licence);
        if (rental == null) {
            return 0;
        }
        int refill = fillAndReturnAmount(rental);
        if (rental instanceof SmallCar) {
            currentRentals.remove(licence, rental);
            rental.setRentalStatus(false);
            smallCars.add(rental);
            return refill;
        }
        if (rental instanceof LargeCar) {
            currentRentals.remove(licence, rental);
            rental.setRentalStatus(false);
            largeCars.add(rental);
            return refill;
        }
        return 0;
    }

    /**
     * Helper for filling a car upon return. If necessary, fills the car and returns the amount
     * that was needed to fill.
     * @param car A car
     * @return The amount of fuel needed to fill it.
     */
    private int fillAndReturnAmount(Car car) {
        int fuelRemaining = car.getFuelRemaining();
        int capacity = car.getCapacity();
        if (car.isFull()) {
            return 0;
        } else if (fuelRemaining < 0) {
            return car.addFuel(capacity + Math.abs(fuelRemaining));
        }
        return car.addFuel(capacity - fuelRemaining);
    }


}
