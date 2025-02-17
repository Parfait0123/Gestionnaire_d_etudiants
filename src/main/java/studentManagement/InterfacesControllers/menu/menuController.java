package studentManagement.InterfacesControllers.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import studentManagement.InterfacesControllers.classs.ClassController;
import studentManagement.InterfacesControllers.myAccount.myAccountController;
import studentManagement.InterfacesControllers.notes.NotesManagementController;
import studentManagement.InterfacesControllers.student.StudentManagementController;
import studentManagement.InterfacesControllers.subject.SubjectManagementController;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class menuController implements Initializable {
    @FXML
    private AnchorPane big_pane;
    @FXML
    private Label class_presentation_label;

    @FXML
    private Label last_modification_label;

    @FXML
    private AnchorPane menu_view;

    @FXML
    private Label user_name_label;

    private AnchorPane menuViewCopy;
    private boolean copy = true;

    @FXML
    void about(ActionEvent event) {

    }

    @FXML
    void card_generator(ActionEvent event) {

    }

    @FXML
    void modify_history(ActionEvent event) {

    }

    @FXML
    void class_management(ActionEvent event) throws IOException {
        openNewWindow(new FXMLLoader(ClassController.class.getResource("ClassManagement.fxml")));
    }

    @FXML
    void class_performances(ActionEvent event) {

    }

    @FXML
    void home(ActionEvent event) throws IOException {
        openNewWindow(new FXMLLoader(menuOnlyController.class.getResource("menuOnly.fxml")));
    }

    @FXML
    void manage_matter(ActionEvent event) throws IOException {
        openNewWindow(new FXMLLoader(SubjectManagementController.class.getResource("SubjectManagement.fxml")));
    }

    @FXML
    void manage_notes(ActionEvent event) throws IOException {
        openNewWindow(new FXMLLoader(NotesManagementController.class.getResource("notesManagement.fxml")));
    }

    @FXML
    void manage_student(ActionEvent event) throws IOException {
        openNewWindow(new FXMLLoader(StudentManagementController.class.getResource("StudentManagement.fxml")));
    }

    @FXML
    void my_account(ActionEvent event) throws IOException {
       openNewWindow(new FXMLLoader(myAccountController.class.getResource("myAccount.fxml")));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void leave(ActionEvent actionEvent) {
        System.exit(0);
    }

    void openNewWindow(FXMLLoader loader) throws IOException {

        menu_view.getChildren().clear();
        AnchorPane pane = loader.load();
        menu_view.getChildren().setAll(pane);
    }
}

