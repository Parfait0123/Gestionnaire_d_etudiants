package studentManagement.InterfacesControllers.student;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class studentProfileController implements Initializable {

    @FXML
    private Pane profile_Pane;

    @FXML
    private Label student_firstName_field;

    @FXML
    private Label student_id_field;

    @FXML
    private Label student_lastName_field;

    @FXML
    private ImageView student_photo_field;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void profil_presed(MouseEvent mouseEvent) {
    }
}
