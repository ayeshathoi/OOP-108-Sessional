package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class ViewerController {




    @FXML
    private TextField BuyCarReg;


    Main main=new Main();
        @FXML
        private TextField RegEdit;

        @FXML
        private TextField newCarPrice;

        @FXML
        private Button save;

        @FXML
        TableView<Car> table;

        @FXML
        private TableColumn<Car,String> carReg;

        @FXML
        private TableColumn<Car,Integer> YearMade;

        @FXML
        private TableColumn<Car, String> color1;

        @FXML
        private TableColumn<Car, String> color2;

        @FXML
        private TableColumn<Car, String> color3;

        @FXML
        private TableColumn<Car, String> carMake;

        @FXML
        private TableColumn<Car, String> carModel;

        @FXML
        private TableColumn<Car, Integer> price;

        @FXML
        private TableColumn<Car, Integer> quantity;


        @FXML
        private TextField newQuantity;

        @FXML
        private TextField DeteleCarReg;

        @FXML
        private ImageView img;
        Image l = new Image(Main.class.getResourceAsStream("database.png"));



        public void load(List carlist) {

            ObservableList<Car> list= FXCollections.observableArrayList(carlist);

            carReg.setCellValueFactory(new PropertyValueFactory<Car,String>("carReg"));
            YearMade.setCellValueFactory(new PropertyValueFactory<Car,Integer>("yearMade"));
            color1.setCellValueFactory(new PropertyValueFactory<Car,String>("color1"));
            color2.setCellValueFactory(new PropertyValueFactory<Car,String>("color2"));
            color3.setCellValueFactory(new PropertyValueFactory<Car,String>("color3"));
            carMake.setCellValueFactory(new PropertyValueFactory<Car,String>("carMake"));
            carModel.setCellValueFactory(new PropertyValueFactory<Car,String>("CarModel"));
            price.setCellValueFactory(new PropertyValueFactory<Car,Integer>("price"));
            quantity.setCellValueFactory(new PropertyValueFactory<Car,Integer>("quantity"));

            table.setItems(list);

        }




        public void LogoutButtonClicked(ActionEvent actionEvent)throws Exception {
            main.showViewerPage=false;
            main.showLoginPage();
        }
        public void setMain(Main main){
            this.main=main;
        }

    public void OptionButtonClicked(ActionEvent actionEvent)throws  Exception {
            main.showViewerPage=false;
            main.showSearchBuyPage();
    }
}
