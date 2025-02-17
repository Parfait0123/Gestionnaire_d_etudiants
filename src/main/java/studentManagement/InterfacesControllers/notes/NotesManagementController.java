package studentManagement.InterfacesControllers.notes;

import animatefx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class NotesManagementController implements Initializable {

    @FXML
    private Button add_new_sheet_button;

    @FXML
    private Pane bilanPane;
    @FXML
    private BorderPane studentReport_BorderPane;

    @FXML
    private TableView<?> bilan_tableView;

    @FXML
    private TableColumn<?, ?> firstName_bilan_column;

    @FXML
    private TableColumn<?, ?> id_bilan_column;

    @FXML
    private TableColumn<?, ?> lastName_bilan_column;

    @FXML
    private Pane menu_pane;

    @FXML
    private HBox modification_hbox;
    @FXML
    private VBox menu_vbox;

    @FXML
    private TableColumn<?, ?> n_bilan_column;

    @FXML
    private AnchorPane note_view;

    @FXML
    private StackPane principal_view_stackpane;

    @FXML
    private Button remove_button;

    @FXML
    private Button remove_button1;

    @FXML
    private Button remove_button11;

    @FXML
    private Button remove_current_sheet_button;

    @FXML
    private ChoiceBox<?> search_mode_choiceBox;

    @FXML
    private TextField search_with_name_field;

    @FXML
    private Button see_current_sheet_button;

    @FXML
    private DatePicker semester_begining_dateOicker;

    @FXML
    private DatePicker semester_end_dateOicker;

    @FXML
    private ChoiceBox<?> semester_list_choiceBox;

    @FXML
    private VBox semester_view_vbox;

    @FXML
    private Pane sheetList_Pane;

    @FXML
    private TableColumn<?, ?> sheetList_code_column;

    @FXML
    private TableColumn<?, ?> sheetList_id_column;

    @FXML
    private TableColumn<?, ?> sheetList_loan_column;

    @FXML
    private TableColumn<?, ?> sheetList_semester_column;

    @FXML
    private TableColumn<?, ?> sheetList_session_column;

    @FXML
    private TableColumn<?, ?> sheetList_subjectName_column;

    @FXML
    private TableView<?> sheetList_tableView;

    @FXML
    private TableColumn<?, ?> sheetList_ue_column;

    @FXML
    private StackPane sheetStackpane;

    @FXML
    private TableColumn<?, ?> sheet_firstName_name;

    @FXML
    private Pane sheet_form_Pane;

    @FXML
    private TableColumn<?, ?> sheet_lastName_column;

    @FXML
    private TableColumn<?, ?> sheet_matricule_column;

    @FXML
    private TableColumn<?, ?> sheet_mean_column;

    @FXML
    private TableColumn<?, ?> sheet_minimalNote_column;

    @FXML
    private TableColumn<?, ?> sheet_n_column;

    @FXML
    private Label sheet_session;

    @FXML
    private Label sheet_subject_name;

    @FXML
    private Label sheet_subject_ue_name;

    @FXML
    private TableView<?> sheet_tableView;

    @FXML
    private TableColumn<?, ?> studentReport_exam1_column;

    @FXML
    private TableColumn<?, ?> studentReport_loan_column;

    @FXML
    private ChoiceBox<?> studentReport_semester_choiceBox;

    @FXML
    private StackPane studentReport_stackPane;

    @FXML
    private Label studentReport_studentName;

    @FXML
    private ChoiceBox<?> studentReport_student_choiceBox;

    @FXML
    private Label studentReport_student_credit;

    @FXML
    private Label studentReport_student_credit_total;

    @FXML
    private Label studentReport_student_mean;

    @FXML
    private Label studentReport_student_percent;

    @FXML
    private Label studentReport_student_rang;

    @FXML
    private TableColumn<?, ?> studentReport_subdject_column;

    @FXML
    private TableColumn<?, ?> studentReport_task1_column;

    @FXML
    private TableColumn<?, ?> studentReport_ue_column;
    private Pane temp;

    @FXML
    void add_new_note_to_this_sheet(ActionEvent event) {

    }

    @FXML
    void add_new_sheet(ActionEvent event) throws IOException {
        temp = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("newNotesform.fxml")));
        new ZoomInDown(temp).play();
        temp.setLayoutX(275);
        temp.setLayoutY(200);
        sheetList_Pane.getChildren().add(temp);
    }

    @FXML
    void edict_this_sheet(ActionEvent event) {
        view(sheetList_Pane, sheet_form_Pane, sheet_form_Pane);
    }

    @FXML
    void openBilanPane(ActionEvent event) {
        changeView(menu_pane, bilanPane);
        decline(bilanPane);
    }

    @FXML
    void openPrintPane(ActionEvent event) {

    }

    @FXML
    void openSchoolReportPane(ActionEvent event) {
        view(menu_pane, studentReport_stackPane, studentReport_BorderPane);
        decline(studentReport_BorderPane);
    }


    @FXML
    void openSheetPane(ActionEvent event) {
        changeView(menu_pane, sheetStackpane);
        decline(sheetList_Pane);
    }

    @FXML
    void remove_a_note_to_this_sheet(ActionEvent event) {

    }

    @FXML
    void remove_current_sheet(ActionEvent event) {

    }

    @FXML
    void return_to_menu(ActionEvent event) {
        changeView(sheetStackpane, menu_pane);
        changeView(bilanPane, menu_pane);
        changeView(studentReport_stackPane, menu_pane);
        decline(menu_vbox);
        sheetList_Pane.getChildren().remove(temp);
    }

    @FXML
    void return_to_sheet_list(ActionEvent event) {
        changeView(sheet_form_Pane, sheetList_Pane);
        decline(sheetList_Pane);
        sheetList_Pane.getChildren().remove(temp);
    }

    @FXML
    void edict_this_sheet_head(ActionEvent event) {

    }

    @FXML
    void save_sheet(ActionEvent event) {

    }

    @FXML
    void search_with_name(ActionEvent event) {

    }

    @FXML
    void see_current_sheet(ActionEvent event) {
        view(sheetList_Pane, sheet_form_Pane, sheet_form_Pane);

    }

    @FXML
    void shcool_year_label(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void changeView(Node oldNode, Node newNode) {
        oldNode.setVisible(false);
        newNode.setVisible(true);
    }

    private void view(Pane menuPane, Pane studentReportStackPane, Pane studentReportBorderPane) {
        changeView(menuPane, studentReportStackPane);
        decline(studentReportStackPane);
    }

    public void decline(Pane pane) {
        for (Node node : pane.getChildren()) {
            Random rd = new Random();
            int n = rd.nextInt(1, 5);
            if (n == 1) new FadeInRight(node).play();
            if (n == 2) new FadeInLeft(node).play();
            if (n == 3) new FadeInUp(node).play();
            if (n == 4) new FadeInDown(node).play();

        }
    }

}
