package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class LoginPageController {
    private Main main;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ImageView i1;
    @FXML
    private ImageView i2;
    @FXML
    private ImageView i3;
    @FXML
    private ImageView i4;

    Image l = new Image(Main.class.getResourceAsStream("login.png"));
    Image n = new Image(Main.class.getResourceAsStream("car.png"));
    Image m = new Image(Main.class.getResourceAsStream("buycarlogo.png"));
    Image x = new Image(Main.class.getResourceAsStream("server.png"));

    public void ResetButtonClicked(ActionEvent actionEvent) {
        username.setText(null);
        password.setText(null);

    }

    public void SubmitButtonClicked(ActionEvent actionEvent) throws Exception {
        String userName=username.getText();
        String passWord=password.getText();
        main.login(userName,passWord);
    }
    public void setMain(Main main){this.main=main;}
}
