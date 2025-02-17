package studentManagement.InterfacesControllers.subject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class newNotesformController implements Initializable {

    @FXML
    private ChoiceBox<?> session_choiceBox;

    @FXML
    private ChoiceBox<?> subject_choiceBox;

    @FXML
    private ChoiceBox<?> ue_choiceBox;

    @FXML
    void return_to_view(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
