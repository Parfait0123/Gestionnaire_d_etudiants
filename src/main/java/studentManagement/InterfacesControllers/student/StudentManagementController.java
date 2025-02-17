package studentManagement.InterfacesControllers.student;

import animatefx.animation.FadeInLeft;
import animatefx.animation.FadeOutLeft;
import animatefx.animation.Flash;
import animatefx.animation.ZoomInDown;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class StudentManagementController implements Initializable {

    @FXML
    private TableColumn<?, ?> class_matricule_column;

    @FXML
    private AnchorPane class_view;

    @FXML
    private Button edit_selected_class_button;

    @FXML
    private Pane empty_view_pane;

    @FXML
    private Pane photo_mode_view_pane;

    @FXML
    private Button print_table_button;

    @FXML
    private Button remove_selected_student_button;

    @FXML
    private TextField search_with_sector_field;

    @FXML
    private TableColumn<?, ?> student_birthday_column;

    @FXML
    private TableColumn<?, ?> student_firstName_column;

    @FXML
    private TableColumn<?, ?> student_lastName_column;

    @FXML
    private TableColumn<?, ?> student_mail_column;

    @FXML
    private TableColumn<?, ?> student_n_column;

    @FXML
    private TableColumn<?, ?> student_sex_column;

    @FXML
    private TableView<?> student_table;

    @FXML
    private Label students_number_field;

    @FXML
    private StackPane students_view_stackPane;

    @FXML
    private Pane table_mode_pane;

    @FXML
    private MenuButton view_mode_menuButton;

    @FXML
    void edit_selected_student(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("edict_student_form.fxml"));
        Pane pane = loader.load();
        EdictStudentFormController a = loader.getController();
        a.setConfirm_button_text("Modifier");
        new ZoomInDown(pane).play();
        pane.setLayoutX(275);
        pane.setLayoutY(10);
        class_view.getChildren().add(pane);
    }

    @FXML
    void add_new_student(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("edict_student_form.fxml")));
        new ZoomInDown(pane).play();
        pane.setLayoutX(275);
        pane.setLayoutY(10);
        class_view.getChildren().add(pane);
        ImageIO.write(SwingFXUtils.fromFXImage(student_table.snapshot(null,null),null),"png",new File("ab.png"));
    }

    @FXML
    void print_table(ActionEvent event) {

    }

    @FXML
    void remove_selected_student(ActionEvent event) {

    }

    @FXML
    void search_more(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("edict_student_form.fxml")));
        new ZoomInDown(pane).play();
        pane.setLayoutX(275);
        pane.setLayoutY(10);
        class_view.getChildren().add(pane);
    }

    @FXML
    void search_with_field(ActionEvent event) {

    }

    @FXML
    void switch_table_view_mode(ActionEvent event) {
        photo_mode_view_pane.setVisible(false);
        table_mode_pane.setVisible(true);
        new Flash(table_mode_pane).play();
    }

    @FXML
    void switch_photo_view_mode(ActionEvent event) {
        table_mode_pane.setVisible(false);
        photo_mode_view_pane.setVisible(true);
        new Flash(photo_mode_view_pane).play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
