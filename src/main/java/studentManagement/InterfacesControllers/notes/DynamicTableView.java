package studentManagement.InterfacesControllers.notes;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class DynamicTableView extends Application {

    private TableView<Person> tableView = new TableView<>();
    private ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("John", "Doe"),
            new Person("Jane", "Doe")
    );
    private int columnIndex = 2; // Starts at 2 because we already have 2 columns


    @Override
    public void start(Stage stage) {
        // Initial columns
        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tableView.getColumns().addAll(firstNameCol, lastNameCol);
        tableView.setItems(data);

        // Button to add a new column
        Button addButton = new Button("Add Column");
        addButton.setOnAction(e -> {
            try {
                addNewColumn();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Layout
        VBox vbox = new VBox();
        vbox.getChildren().addAll(tableView, addButton);

        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Dynamic TableView Example");
        stage.show();
    }

    private void addNewColumn() throws IOException {
        TableColumn<Person, String> newCol = new TableColumn<>("Column " + columnIndex);
        newCol.setCellValueFactory(_ -> new SimpleStringProperty("Data " + columnIndex));

        tableView.getColumns().add(newCol);
        columnIndex++;
        ImageIO.write(SwingFXUtils.fromFXImage(tableView.snapshot(null, new WritableImage(1000, 600)), null), "png", new File("afb.png"));
        tableView.sort();
    }

    public static class Person {
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;

        private Person(String fName, String lName) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }
    }
}