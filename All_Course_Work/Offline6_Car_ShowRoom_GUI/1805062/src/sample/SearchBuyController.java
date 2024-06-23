package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SearchBuyController {
    Main main;
    public void setMain(Main main){
        this.main=main;
    }
    @FXML
    private TextField SearchCarID;

    @FXML
    private TextField searchCarMake;

    @FXML
    private TextField SearchCarModel;
    @FXML
    private TextField BuyCarReg;


    @FXML
    void BuyButtonClicked(ActionEvent event)throws Exception{
        String buyCar=BuyCarReg.getText();
        BuyCarReg.setText(null);
        main.BuyCar("Buy "+buyCar);




    }

    @FXML
    void SearchButtonClicked(ActionEvent event)throws Exception {

        String searchID=SearchCarID.getText();
        SearchCarID.setText(null);
        String carMake=searchCarMake.getText();
       searchCarMake.setText(null);
        String carModel=SearchCarModel.getText();
        SearchCarModel.setText(null);
        if(searchID.equals("")){
            System.out.println("Inside");
         main.searchCar("Search "+carMake+" "+carModel);
        }
        else
            main.searchCar("Search "+searchID);

    }

    public void BackToMainPageClicked(ActionEvent actionEvent)throws Exception {

        main.showViewPage();
    }
}
