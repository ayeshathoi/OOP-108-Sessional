package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MnEditRemoveControllerCar {
    Main main;
    @FXML
    private TextField RegEdit;

    @FXML
    private TextField newCarPrice;

    @FXML
    private TextField newCarQuantity;

    @FXML
    private TextField DeleteCarReg;

    @FXML
    private ImageView d;
    Image k = new Image(Main.class.getResourceAsStream("download.png"));

    @FXML
    void DeleteButtonClicked(ActionEvent event)throws Exception {
        String carReg=DeleteCarReg.getText();
        DeleteCarReg.setText(null);
        main.deleteCar("Delete"+" "+carReg);
    }

    @FXML
    void SaveButtonClicked(ActionEvent event)throws Exception {
        main.changeValue("Edit"+" "+RegEdit.getText()+" "+newCarPrice.getText()+" "+newCarQuantity.getText());
      //  main.showManufacturerPage=true;

    }
    public void setMain(Main main){
        this.main=main;
    }

    public void BackToMainPageClicked(ActionEvent actionEvent)throws Exception {
        main.showManufacturerPage=true;
        //main.showManufacturer();
    }
}
