package studentManagement.InterfacesControllers.student;

import animatefx.animation.FadeInLeft;
import animatefx.animation.FadeInRight;
import animatefx.animation.ZoomOutDown;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class EdictStudentFormController implements Initializable {

    @FXML
    private DatePicker birthday_datepicker;

    @FXML
    private Button confirm_button;

    @FXML
    private CheckBox confirm_checkbox;

    @FXML
    private TextField email_field;

    @FXML
    private RadioButton feminine_radioButton;

    @FXML
    private VBox firstPage_vbox;

    @FXML
    private TextField fistname_field;

    @FXML
    private TextField lastAverage_field;

    @FXML
    private TextField lastname_field;

    @FXML
    private TextField location_born_field;

    @FXML
    private RadioButton masculine_radioButton;

    @FXML
    private TextField matricule_field;

    @FXML
    private TextField nationality_field;

    @FXML
    private Button nextPage_button;

    @FXML
    private TextField npi_field;

    @FXML
    private TextArea othersinformations_textArea;

    @FXML
    private TextField phoneNumber_field;

    @FXML
    private Button previousPage_button;

    @FXML
    private VBox secondpage_vbox;

    @FXML
    private ImageView studentphoto_imageView;

    @FXML
    void confirm(ActionEvent event) {
        if (confirm_button.getText().equals("Modifier")) confirm_button.setText("Enrégistrer");
        if ((confirm_button.getText().equals("Enrégistrer") || confirm_button.getText().equals("Ajouter")) && confirm_checkbox.isSelected()){
            Node node= (Node) event.getSource();
            new ZoomOutDown(node.getParent()).play();
        }

    }

    @FXML
    void previousPage(ActionEvent event) {
        secondpage_vbox.setVisible(false);
        firstPage_vbox.setVisible(true);
        new FadeInLeft(firstPage_vbox).play();
    }

    @FXML
    void nextPage(ActionEvent event) {
        secondpage_vbox.setVisible(true);
        firstPage_vbox.setVisible(false);
        new FadeInRight(secondpage_vbox).play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setConfirm_button_text(String text) {
        confirm_button.setText(text);
    }
    @FXML
    void close(ActionEvent event) {
        Node node= (Node) event.getSource();
        new ZoomOutDown(node.getParent()).play();
    }

    Button getConfirm_button() {
        return confirm_button;
    }
}
