package sample;

import java.io.Serializable;

public class Car implements Serializable {
    private String carReg;
    private int yearMade;
    private String color1;
    private String color2;
    private String color3;
    private String carMake;
    private String carModel;
    private int price;
    private int quantity;

    public Car(String carReg, int yearMade, String color1, String color2, String color3, String carMake, String carModel, int price, int quantity) {
        this.carReg = carReg;
        this.yearMade = yearMade;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.carMake = carMake;
        this.carModel=carModel;
        this.price = price;
        this.quantity=quantity;
    }

    public String getCarReg() {
        return carReg;
    }

    public int getYearMade() {
        return yearMade;
    }

    public String getColor1() {
        return color1;
    }

    public String getColor2() {
        return color2;
    }

    public String getColor3() {
        return color3;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCarReg(String carReg) {
        this.carReg = carReg;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  carReg + "," +
                yearMade + "," +
                color1 +  "," + color2 +  ","+ color3 +  ","+
                carMake +  "," +
                carModel + "," +
                price+","+quantity ;

    }


}
