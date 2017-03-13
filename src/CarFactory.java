/**
 * Factory class containing single factory method to allow creation
 * of different car types based on a String parameter.
 */
public class CarFactory {

    /**
     * A factory method which returns A SmallCar object
     * if typeOfCar equals "small" and a LargeCar object
     * if typeOfCar equals "large". Will return null for
     * any other String.
     * @param typeOfCar A string naming the type of car requested.
     * @return An instance of SmallCar, LargeCar, or null.
     */
    public static Car getInstance(String typeOfCar) {
        if (typeOfCar.equals("small")) return new SmallCar();
        if (typeOfCar.equals("large")) return new LargeCar();
        return null;
    }

}
