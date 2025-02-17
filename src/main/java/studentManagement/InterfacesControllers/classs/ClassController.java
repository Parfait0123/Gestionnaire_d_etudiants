package studentManagement.InterfacesControllers.classs;

import animatefx.animation.ZoomInDown;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.beans.binding.Bindings.when;

public class ClassController implements Initializable {

    @FXML
    private TableColumn<?, ?> class_id_column;

    @FXML
    private TableColumn<?, ?> class_school_column;

    @FXML
    private TableColumn<?, ?> class_school_year_column;

    @FXML
    private TableColumn<?, ?> class_sector_column;

    @FXML
    private TableColumn<?, ?> class_study_year_column;

    @FXML
    private TableView<?> class_table;

    @FXML
    private TableColumn<?, ?> class_university_column;

    @FXML
    private AnchorPane class_view;

    @FXML
    private TextField new_class_university_field;


    @FXML
    private Button edit_selected_class_button;

    @FXML
    private Button manage_selected_class_button;

    @FXML
    private Button remove_selected_class_button;
    @FXML
    private Button new_class_button;
    @FXML
    private TextField search_with_sector_field;
    private boolean canOpenForm = true;

    @FXML
    void add_new_class(ActionEvent event) throws Exception {
        showNewClassForm(event);
    }

    @FXML
    void edit_selected_class(ActionEvent event) throws IOException {
        showNewClassForm(event);
    }

    @FXML
    void manage_selected_class(ActionEvent event) {

    }

    @FXML
    void remove_selected_class(ActionEvent event) {

    }

    @FXML
    void search_with_field(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    void showNewClassForm(ActionEvent event) throws IOException {
//        new_class_button.disableProperty().bind(when(((Node) event.getSource()).getParent().visibleProperty()).then(false).otherwise(true));
//        edit_selected_class_button.disableProperty().bind(when(((Node) event.getSource()).visibleProperty()).then(true).otherwise(false));
        Pane form = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("formNewClass.fxml")));
        form.setLayoutX(275);
        form.setLayoutY(10);
        class_view.getChildren().add(form);
        new ZoomInDown(form).play();
    }

    void setCanOpenForm(boolean canOpenForm) {
        this.canOpenForm = canOpenForm;
    }
}
