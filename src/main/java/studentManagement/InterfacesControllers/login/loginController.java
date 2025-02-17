package studentManagement.InterfacesControllers.login;

import animatefx.animation.ZoomInDown;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import studentManagement.Classes.User;
import studentManagement.InterfacesControllers.menu.menuController;
import studentManagement.SqliteConnection.SqliteConnection;

import javax.management.Notification;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import org.controlsfx.control.Notifications;

public class loginController implements Initializable {

    private User user;
    private SqliteConnection connection;
    private PasswordVisibilityHelper passwordHelper;
    private PasswordVisibilityHelper passwordHelper1;
    private PasswordVisibilityHelper passwordHelper2;
    @FXML
    private ImageView btnPasswordVisibility;
    @FXML
    private ImageView btnPasswordVisibility1;
    @FXML
    private ImageView btnPasswordVisibility2;
    @FXML
    private ProgressIndicator progressbar;
    @FXML
    private ProgressIndicator progressbar1;
    @FXML
    private AnchorPane login_anchropane;
    @FXML
    private HBox passeword_hbox;
    @FXML
    private Button login_Button;

    @FXML
    private Pane login_Pane;

    @FXML
    private TextField login_User_name_Field;

    @FXML
    private PasswordField login_User_password_Field;
    @FXML
    private TextField login_User_password_Field2;
    @FXML
    private TextField sign_up_password_Field2;
    @FXML
    private TextField sign_up_confirm_pass_Field2;

    @FXML
    private RadioButton login_account_type_Admin_RadioButton;

    @FXML
    private RadioButton login_account_type_Student_RadioButton;

    @FXML
    private Button login_go_to_signup_Button;

    @FXML
    private RadioButton sign_up_admin_radio;

    @FXML
    private TextField sign_up_authorization_code_Field;

    @FXML
    private PasswordField sign_up_confirm_pass_Field;

    @FXML
    private TextField sign_up_email_Field;

    @FXML
    private TextField sign_up_first_name_Field;

    @FXML
    private TextField sign_up_last_name_Field;

    @FXML
    private PasswordField sign_up_password_Field;

    @FXML
    private RadioButton sign_up_student_radio;

    @FXML
    private TextField sign_up_user_name_Field;

    @FXML
    private Pane signup_Pane;

    @FXML
    void go_to_signup() {
        new ZoomInDown(signup_Pane).play();
        login_Pane.setVisible(false);
        signup_Pane.setVisible(true);
        signup_Pane.requestFocus();
    }

    @FXML
    void leave_Button() {
        System.exit(0);
    }

    @FXML
    void login(ActionEvent event) {

        turnProgressBar(progressbar);
        Timer timer = new Timer();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(() -> {

                            String userName = login_User_name_Field.getText().trim();
                            String password = login_User_password_Field.getText().trim();
                            String type = "";
                            if (login_account_type_Admin_RadioButton.isSelected()) type = "admin";
                            else if (login_account_type_Student_RadioButton.isSelected()) type = "student";
                            if (login_User_password_Field2.isVisible()) password = login_User_password_Field2.getText();
                            boolean temp = !(login_account_type_Admin_RadioButton.isSelected() || login_account_type_Student_RadioButton.isSelected());
                            if (userName.isBlank() || password.isBlank() || temp) {
                                Notifications notification = Notifications.create().title("Champ vide");
                                String s = "";
                                if (userName.isBlank()) s = "Veuillez renseigner le nom d'utilisateur ";
                                if (password.isBlank()) s = s.concat("\n Veuillez renseigner le mot de passe ");
                                if (temp) s = s.concat("\n Sélectionnez le type du compte ");
                                notification.text(s);
                                notification.showWarning();

                            } else {
                                ArrayList<User> users = null;
                                users = connection.getUsers();
                                boolean temp1 = true;
                                for (User user : users) {
                                    System.out.println(user.getUserName() + "   " + user.getPassword());
                                    if (user.getUserName().equals(userName) && user.getPassword().equals(password) && user.getRole().equals(type)) {
                                        setUser(user);
                                        open();
                                        Notifications r = Notifications.create().title("Connexion réussie");
                                        r.getStyleClass().add("studentManagement/InterfacesControllers/head.css");
                                        r.styleClass("newStyle");
                                        r.showInformation();
                                        temp1 = false;
                                        break;
                                    }
                                }
                                if (temp1) {
                                    Notifications.create().title("Compte non retrouvé ").text(" Vérifiez vos identifiants").showError();
                                }
                            }
                        });

                    }
                }, 1500);


    }


    @FXML
    void return_to_login() {
        signup_Pane.setVisible(false);
        new ZoomInDown(login_Pane).play();
        login_Pane.setVisible(true);
    }

    @FXML
    void signup() {
        turnProgressBar(progressbar1);

        String userName = sign_up_user_name_Field.getText().trim();
        String userPassword = sign_up_password_Field.getText().trim();
        if (sign_up_password_Field2.isVisible())
            userPassword = sign_up_password_Field2.getText().trim();
        String userPassword2 = sign_up_confirm_pass_Field.getText().trim();
        if (sign_up_confirm_pass_Field2.isVisible())
            userPassword2 = sign_up_confirm_pass_Field2.getText().trim();
        String userEmail = sign_up_email_Field.getText().trim();
        String userFirstName = sign_up_first_name_Field.getText().trim();
        String userLastName = sign_up_last_name_Field.getText().trim();
        String authorizationCode = sign_up_authorization_code_Field.getText().trim();
        boolean valid = true;
        String regex1 = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        String regex2 = "^[a-zA-Z0-9]+$";
        StringBuilder s = new StringBuilder();
        ArrayList<User> users = connection.getUsers();
        if (userLastName.isEmpty() || !userLastName.matches(regex2)) {
            valid = false;
            s = new StringBuilder(" Nom invalide ");
        }
        if (userFirstName.isEmpty() || !userFirstName.matches(regex2)) {
            valid = false;
            s.append("\n\n Prénom invalide ");
        }
        if (userName.isEmpty() || !userName.matches(regex2)) {
            valid = false;
            s.append("\n\n Nom d'utilisateur invalide ");
            for (User user : users) {
                if (Objects.equals(user.getUserName(), userName))
                    s.append("\n\n Essayez un autre nom d'utilisateur ");
                break;
            }
        }
        if (userEmail.isEmpty() || !userEmail.matches(regex1)) {
            valid = false;
            s.append("\n\n Email invalide ");
        }
        String passRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        String passMsg = "";
        if (userPassword.isEmpty() || !userPassword.matches(passRegex)) {
            valid = false;
            passMsg = """
                     Votre mot de passe doit contenir :\s

                    1. Au moins 8 caractères.
                    2. Au moins une lettre majuscule.
                    3. Au moins une lettre minuscule.
                    4. Au moins un chiffre.
                    5. Au moins un caractère spécial (comme `@`, `#`, `$`, etc.).""";
        }
        if (!userPassword2.equals(userPassword)) {
            valid = false;
            passMsg = " Le second mot de passe doit etre identique au premier";
        }
        if (!sign_up_admin_radio.isSelected() && !sign_up_student_radio.isSelected()) {
            valid = false;
            s.append("\n\n Choisissez le type du compte ");
        }


        Timer timer = new Timer();
        String finalPassMsg = passMsg;
        StringBuilder finalS = s;
        boolean finalValid = valid;
        String finalUserPassword = userPassword;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (!finalValid) {
                        Notifications notification = Notifications.create().title("Erreur d'entrés ").text(finalS.toString());
                        notification.showError();
                        if (!finalPassMsg.isEmpty()) {
                            Notifications notification1 = Notifications.create().title("Mot de passe ").text(finalPassMsg);
                            notification1.showError();
                        }
                    } else {
                        String userRole = "";
                        if (sign_up_admin_radio.isSelected()) {
                            userRole = "admin";
                        } else userRole = "student";
                        user = new User(userFirstName, userLastName, userEmail, finalUserPassword, userName, userRole);
                        if (connection.sendUser(user))
                            open();
                        else {
                            Notifications.create().title("Erreur de création du compte ").text("Changez d'identifiant svp ! ").showError();
                        }
                    }
                });
            }
        }, 1500);


        if (!authorizationCode.trim().isEmpty()) {
            //Télécharger la base de données et l'affecter au compte
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connection = new SqliteConnection();
        passwordHelper = new PasswordVisibilityHelper(login_User_password_Field, btnPasswordVisibility);
        passwordHelper1 = new PasswordVisibilityHelper(sign_up_password_Field, btnPasswordVisibility1);
        passwordHelper2 = new PasswordVisibilityHelper(sign_up_confirm_pass_Field, btnPasswordVisibility2);
        ToggleGroup group = new ToggleGroup();
        login_account_type_Admin_RadioButton.setToggleGroup(group);
        login_account_type_Student_RadioButton.setToggleGroup(group);
        ToggleGroup group1 = new ToggleGroup();
        sign_up_admin_radio.setToggleGroup(group1);
        sign_up_student_radio.setToggleGroup(group1);
    }


    public void onChangePasswordVisibility(MouseEvent mouseEvent) {
        changeVisibility(login_User_password_Field2, login_User_password_Field, passwordHelper);
    }


    @FXML
    public void onChangePasswordVisibility1_Signup(MouseEvent mouseEvent) {
        changeVisibility(sign_up_password_Field2, sign_up_password_Field, passwordHelper1);
    }


    @FXML
    public void onChangePasswordVisibility2_signup(MouseEvent mouseEvent) {
        changeVisibility(sign_up_confirm_pass_Field2, sign_up_confirm_pass_Field, passwordHelper2);
    }


    private void changeVisibility(TextField textField, PasswordField passwordField, PasswordVisibilityHelper passwordHelper) {
        passwordHelper.toggleVisibility();
        if (!textField.isVisible()) {
            textField.setVisible(true);
            textField.setText(passwordField.getText());
        } else {
            textField.setVisible(false);
            passwordField.setText(textField.getText());
        }
    }


    private void turnProgressBar(ProgressIndicator progressBar) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), _ -> {
            double progress = progressBar.getProgress() + 0.01;
            if (progress > 1)
                progress = 0;
            progressBar.setProgress(progress);
        }));
        timeline.setCycleCount(100);
        timeline.play();
    }


    private void open() {
        try {
            AnchorPane newPane = FXMLLoader.load(Objects.requireNonNull(menuController.class.getResource("menu.fxml")));
            while (!login_anchropane.getChildren().isEmpty()) login_anchropane.getChildren().removeFirst();
            login_anchropane.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(newPane));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setUser(User user) {
        this.user = user;
    }
}
