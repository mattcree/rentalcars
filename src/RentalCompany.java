import java.util.*;

/**
 * Created by Cree on 02/03/2017.
 */
public class RentalCompany {

    private static final RentalCompany COMPANY = new RentalCompany();
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
        if (typeOfCar == "large") {
            return largeCars.size();
        } else if (typeOfCar == "small") {
            return smallCars.size();
        } else {
            return -1;
        }
    }

    public Collection<Car> getRentedCars() {
        return this.currentRentals.values();
    }

    public Car getCar(DrivingLicence licence) {
        return currentRentals.get(licence);
    }

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

    private boolean eligibleForSmall(DrivingLicence licence) {
        Date today = new Date();
        return (DrivingLicence.differenceInYears(licence.getDateOfBirth(), today) >= 21) &&
               (DrivingLicence.differenceInYears(licence.getIssueDate(), today) >= 1);
    }

    private boolean eligibleForLarge(DrivingLicence licence) {
        Date today = new Date();
        return (DrivingLicence.differenceInYears(licence.getDateOfBirth(), today) >= 25) &&
               (DrivingLicence.differenceInYears(licence.getIssueDate(), today) >= 5);
    }

    public int terminateRental(DrivingLicence licence) {
        if (currentRentals.get(licence) == null) {
            return 0;
        }
        return 1;
    }

}
