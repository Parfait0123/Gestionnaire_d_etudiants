package studentManagement.InterfacesControllers.subject;

import animatefx.animation.ZoomOutDown;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class subjectDetailsController implements Initializable {

    @FXML
    private TextField loan_field;

    @FXML
    private TextField name_field;

    @FXML
    private TextField techears_name_field;

    @FXML
    private TextField ue_number_field;

    @FXML
    void return_to_view(ActionEvent event) {
        close(event);
    }

    @FXML
    void save(ActionEvent event) {
        Node node= (Node) event.getSource();
        new ZoomOutDown(node.getParent()).play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    private void close(ActionEvent event) {
        Node node= (Node) event.getSource();
        new ZoomOutDown(node.getParent()).play();
    }
}
