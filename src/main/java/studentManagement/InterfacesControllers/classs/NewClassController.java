package studentManagement.InterfacesControllers.classs;

import animatefx.animation.ZoomOutDown;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NewClassController implements Initializable {

    @FXML
    private TextField new_class_school_field;

    @FXML
    private TextField new_class_school_year_field;

    @FXML
    private TextField new_class_sector_field;

    @FXML
    private TextField new_class_study_year_field;

    @FXML
    private TextField new_class_university_field;

    @FXML
    void return_to_table(ActionEvent event) {
        Node a = (Node) (event.getSource());
        new ZoomOutDown(a.getParent()).play();
    }

    @FXML
    void save_class(ActionEvent event) {
        Node a = (Node) (event.getSource());
        new ZoomOutDown(a.getParent()).play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
