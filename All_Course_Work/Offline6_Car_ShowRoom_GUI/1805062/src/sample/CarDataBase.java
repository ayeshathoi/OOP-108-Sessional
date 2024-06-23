package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class CarDataBase implements Serializable {

    private ArrayList<Car> cars = new ArrayList<>();

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public boolean addCar(Car toAdd) {

        cars.add(toAdd);

        return true;
    }

    public Car searchCar(String reg) {
        for (Car c : cars) {
            if (c.getCarReg().equalsIgnoreCase(reg)) {
                System.out.println(c);
                return c;
            }
        }
        Car o=null;
        return o;

    }

    public Car searchCar(String carMake, String carModel) {
        boolean found = false;
        if (carModel.equalsIgnoreCase("ANY")) {
            for (Car c : cars) {
                if (c.getCarMake().equalsIgnoreCase(carMake)) {
                    found = true;
                    System.out.println(c);
                    return c;
                }
            }
        } else {
            for (Car c : cars) {
                if (c.getCarMake().equalsIgnoreCase(carMake) && c.getCarModel().equalsIgnoreCase(carModel)) {
                    System.out.println(c);
                    found=true;
                    return c;

                }
            }
            }
            Car o = null;
            return o;
    }

    public  void removeCar(String  reg) {
        for (Car c : cars) {
            if (c.getCarReg().equalsIgnoreCase(reg)) {
                cars.remove(c);
                System.out.println("The deletion of this car was successful");
                return;
            }

        }
        System.out.println("No such cars found in our database.");return;
    }
    public  int queryCar(String reg){ Car car=null;
        for(Car c:cars){
            if(c.getCarReg().equalsIgnoreCase(reg)){ car=c;
                break;
            }
        } return cars.indexOf(car);
        //return false;
    }
    public void EditCar(int price,int quantity, int index){
        cars.get(index).setPrice(price);
        cars.get(index).setQuantity(quantity);
    }
}
