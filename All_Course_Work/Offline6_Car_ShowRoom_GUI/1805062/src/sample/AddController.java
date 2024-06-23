package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AddController {

    private Main main;

    @FXML
    private TextField carReg;

    @FXML
    private TextField YearMade;

    @FXML
    private TextField Color;

    @FXML
    private TextField Color2;

    @FXML
    private TextField Color3;

    @FXML
    private TextField CarMake;

    @FXML
    private TextField CarModel;

    @FXML
    private TextField Price;

    @FXML
    private ImageView ad;

    Image a = new Image(Main.class.getResourceAsStream("car.png"));

    @FXML
    private TextField quantity;
    public void setMain(Main main){
        this.main=main;
    }

    public void AddClicked(ActionEvent actionEvent)throws Exception {

        Car newCar=new Car(carReg.getText(),Integer.parseInt(YearMade.getText()),Color.getText(),Color2.getText(),Color3.getText(),CarMake.getText(),CarModel.getText(),Integer.parseInt(Price.getText()),Integer.parseInt(quantity.getText()));
         main.AddCar(newCar);
    }



    public void BackToMainPageClicked(ActionEvent actionEvent) throws Exception{
        main.showManufacturer();
    }
}
