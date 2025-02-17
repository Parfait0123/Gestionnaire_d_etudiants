module student_management.all {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires animatefx;
    requires javafx.swing;
    requires java.desktop;
    requires itextpdf;
    requires java.sql;
    requires java.management;
    requires org.controlsfx.controls;


    opens studentManagement.InterfacesControllers.login;
    opens studentManagement.InterfacesControllers.menu ;
    opens studentManagement.InterfacesControllers.classs;
    opens studentManagement.InterfacesControllers.student;
    opens studentManagement.InterfacesControllers.subject;
    opens studentManagement.InterfacesControllers.notes;
    opens studentManagement.InterfacesControllers.myAccount;

}