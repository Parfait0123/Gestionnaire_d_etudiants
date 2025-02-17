package studentManagement.InterfacesControllers.myAccount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class myAccountController implements Initializable {

    @FXML
    private PasswordField newEmailConfirmField;

    @FXML
    private TextField newEmailField;

    @FXML
    private AnchorPane note_view;

    @FXML
    private TextField oldEmailField;

    @FXML
    private PasswordField oldPassword;

    @FXML
    private TabPane passsWordTabpane;

    @FXML
    private PasswordField updatePasswordConfirmField;

    @FXML
    private PasswordField updatepasswordField;

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void saveNEwEmail(ActionEvent event) {

    }

    @FXML
    void saveNewPassword(ActionEvent event) {

    }

    @FXML
    void updateEmail(ActionEvent event) {

    }

    @FXML
    void updatepassword(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
