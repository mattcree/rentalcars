/**
 * Created by Cree on 01/03/2017.
 */
public class CarFactory {

    public static Car getInstance(String typeOfCar) {
        if (typeOfCar.equals("small")) return new SmallCar();
        if (typeOfCar.equals("large")) return new LargeCar();
        return null;
    }

}
