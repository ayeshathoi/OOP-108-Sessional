package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;
import java.util.Optional;

public class Main extends Application {
     Stage stage1;
    Manufacturer manufacturer;
     boolean showManufacturerPage=false;
     boolean showViewerPage=false;
    Viewer viewer;
    List list;

    @Override
    public void start(Stage primaryStage) throws Exception{ stage1=primaryStage; showLoginPage();}

      public void showLoginPage() throws Exception{
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource("loginPage.fxml"));
          Parent root = loader.load();
          LoginPageController controller = loader.getController();
          controller.setMain(this);
          stage1.setTitle("Login Page");
          stage1.setScene(new Scene(root));
          stage1.show();
      }

    public  void showManufacturerPage(List list) throws  Exception{
        showManufacturerPage=true;
        System.out.println("in menu");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Manufacturer.fxml"));
        Parent root = loader.load();
        ManufacturerController controller = loader.getController();
        controller.setMain(this);
        controller.load(list);
        controller.table.refresh();
        stage1.setTitle("Manufacturer Homepage");
        stage1.setScene(new Scene(root ));
        stage1.show();
    }
    public  void showViewerPage(List list) throws  Exception{
        showViewerPage=true;
        System.out.println("in menu");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Viewer.fxml"));
        Parent root = loader.load();
        ViewerController controller = loader.getController();
        controller.setMain(this);
        controller.load(list);
        controller.table.refresh();
        stage1.setTitle("Viewer Homepage");
        stage1.setScene(new Scene(root ));
        stage1.show();
    }

    public void showViewPage()throws Exception{
        showViewerPage=true;

    }
    public void login(String userName,String Password)throws Exception {
        if (userName.equals("ayesha") && Password.equals("391") || userName.equals("mishel") && Password.equals("389") || userName.equals("mouri") && Password.equals("390")) {
            Manufacturer manufacturer = new Manufacturer("Localhost", 12444, this);

            this.manufacturer = manufacturer;

            showManufacturerPage = true;
        }

         else    if (userName.equals("Mahzabin") && Password.equals("")||userName.equals("Tara") && Password.equals("") ) {
                Viewer viewer = new Viewer("localhost", 12444, this);
                this.viewer = viewer;
                showViewerPage((List) viewer.networkUtil.read());
            }
        else {
            // failed login
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username you provided is not correct.");
            alert.showAndWait();
        }
    }
    public void ShowAddPage()throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddCar.fxml"));
        Parent root = loader.load();
        AddController controller = loader.getController();
        controller.setMain(this);
        stage1.setTitle("Add New Car");
        stage1.setScene(new Scene(root ));
        stage1.show();


    }
    public void logout() throws Exception{
        showLoginPage();
    }
    public void setManufacturer(Manufacturer manufacturer){
        this.manufacturer=manufacturer;
    }
    public void setViewer(Viewer viewer){
        this.viewer=viewer;
    }

    public static void main(String[] args) {
        launch(args);
    }


    public void changeValue(String s)throws Exception{
        System.out.println("Sending data "+s);
        manufacturer.networkUtil.write(s);
        System.out.println("updated list :");
        showManufacturerPage=true;
    }
    public void deleteCar(String deletecarReg)throws Exception{
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Car");
        alert.setHeaderText("Conformation of Removal :");
        alert.setContentText("Are you sure you want to delete this car?");

        Optional<ButtonType> action= alert.showAndWait();
        if(action.get()==ButtonType.OK){
        manufacturer.networkUtil.write(deletecarReg);
        List list= (List)manufacturer.networkUtil.read();
        System.out.println("updatedlist\n"+list);
        showManufacturerPage(list);}
     else{
            manufacturer.networkUtil.write("UpdatedList ");
            List list= (List)manufacturer.networkUtil.read();

            showManufacturerPage(list);}
        }



    public void AddCar(Car carToAdd) throws Exception{
        System.out.println("Car to add "+carToAdd);
        this.manufacturer.networkUtil.write((Object) carToAdd);
        showManufacturerPage=true;

    }
    public  void searchCar(String  s)throws Exception{
        System.out.println("Sending Data "+s);
        viewer.networkUtil.write(s);
        Car car=(Car)(viewer.networkUtil.read());
        if(car!=null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Result");
            alert.setHeaderText("Car Information :");
            alert.setContentText(car.toString());
            alert.showAndWait();
        }
        else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Search Result");
            alert.setHeaderText("Car Information :");
            alert.setContentText("No such Cars Found! ");
            alert.showAndWait();

        }

    }
    public void showSearchBuyPage()throws  Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Search&BuyCar.fxml"));
        Parent root = loader.load();
        SearchBuyController controller = loader.getController();
        controller.setMain(this);
        stage1.setTitle("Viewer Options");
        stage1.setScene(new Scene(root ));
        stage1.show();

    }
    public void BuyCar(String BuyCarReg)throws Exception{
        viewer.networkUtil.write(BuyCarReg);
        Car car=(Car)viewer.networkUtil.read();
        if(car!=null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Conformation message");
            alert.setHeaderText("CONGRATULATIONS :");
            alert.setContentText("Now you are the proud owner of A brand new "+car.getCarMake()+" !");
            alert.showAndWait();

        }
        else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle(" Buying Request Denied! ");
            alert.setHeaderText("Error Information :");
            alert.setContentText(" Sorry! We don't have this car in our stock right now!");
            alert.showAndWait();
        }
    }
    public void showManufactureUpdatePage()throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MnEditRemoveCar.fxml"));
        Parent root = loader.load();
        MnEditRemoveControllerCar controller = loader.getController();
        controller.setMain(this);
        stage1.setTitle("Updating Database...");
        stage1.setScene(new Scene(root ));
        stage1.show();
    }
    public void showManufacturer()throws Exception{
        showManufacturerPage=true;
    }
}
