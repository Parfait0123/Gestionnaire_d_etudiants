package studentManagement.InterfacesControllers.subject;

import animatefx.animation.FadeInRight;
import animatefx.animation.FadeOutLeft;
import animatefx.animation.ZoomInDown;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

public class SubjectManagementController {

    @FXML
    private TableColumn<?, ?> subject_database_id_column;
    @FXML
    private TextField search_with_name_field;
    @FXML
    private Button add_button;

    @FXML
    private ImageView current_ImageView;

    @FXML
    private AnchorPane menu_view;

    @FXML
    private HBox modification_hbox;

    @FXML
    private VBox semester_view_vbox;

    @FXML
    private Button modify_button;

    @FXML
    private Pane new_semester_pane;

    @FXML
    private Button remove_button;

    @FXML
    private Button see_or_return_button;

    @FXML
    private DatePicker semester_begining_dateOicker;

    @FXML
    private DatePicker semester_end_dateOicker;

    @FXML
    private ChoiceBox<?> semester_list_choiceBox;

    @FXML
    private TableColumn<?, ?> subject_UE_number_column;

    @FXML
    private TableColumn<?, ?> subject__teacher_name_column;

    @FXML
    private TableColumn<?, ?> subject_id_column;

    @FXML
    private TableColumn<?, ?> subject_loan_column;

    @FXML
    private TableColumn<?, ?> subject_name_column;

    @FXML
    private TableView<?> subject_tableView;

    @FXML
    private TableColumn<?, ?> ue_id_column;

    @FXML
    private TableColumn<?, ?> ue_loan_column;

    @FXML
    private TableColumn<?, ?> ue_name_column;

    @FXML
    private TableView<?> ue_tableView;

    @FXML
    private TableColumn<?, ?> ue_teacher_name_column;

    @FXML
    void add_new_matter(ActionEvent event) throws IOException {
        addView();
    }

    @FXML
    void add_new_semester_to_semesters_list(ActionEvent event) throws IOException {
        changeView(semester_view_vbox, new_semester_pane);
    }

    @FXML
    void create_new_semester(ActionEvent event) throws IOException {
        changeView(new_semester_pane, semester_view_vbox);
    }

    @FXML
    void leave(ActionEvent event) {

    }

    @FXML
    void modify_current_matter(ActionEvent event) throws IOException {
        addView();
    }


    @FXML
    void new_semester_id_field(ActionEvent event) {

    }

    @FXML
    void remove_current_matter(ActionEvent event) {

    }

    @FXML
    void remove_current_semester(ActionEvent event) {

    }

    @FXML
    void return_to_semester_view(ActionEvent event) {
        changeView(new_semester_pane, semester_view_vbox);

    }

    @FXML
    void see_or_return(ActionEvent event) {
        Node newNode;
        Node oldNode;
        if (see_or_return_button.getText().contains("Voir les UE")) {
            newNode = ue_tableView;
            oldNode = subject_tableView;
            see_or_return_button.setText("Retour aux matières");
            add_button.setText("Ajouter une UE");
        } else {
            newNode = subject_tableView;
            oldNode = ue_tableView;
            see_or_return_button.setText("Voir les UE");
            add_button.setText("Ajouter une matière");
        }
        changeView(oldNode, newNode);
    }

    private void changeView(Node oldNode, Node newNode) {
        oldNode.setVisible(false);
        newNode.setVisible(true);
        new FadeInRight(newNode).play();
    }

    private void addView() throws IOException {
        Pane pane;
        if (add_button.getText().contains("Ajouter une matière")) {
            pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("subjectDetails.fxml")));
        } else {
            pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ueDetails.fxml")));
        }
        new ZoomInDown(pane).play();
        pane.setLayoutX(275);
        pane.setLayoutY(200);
        menu_view.getChildren().add(pane);
    }

    @FXML
    public void search_with_name(ActionEvent event) {
    }
}
