package studentManagement.SqliteConnection;

import studentManagement.Classes.User;

import java.sql.*;
import java.util.ArrayList;

public class SqliteConnection {
    private Connection connection;

    public SqliteConnection() {
        String url = "jdbc:sqlite:appLoginDatabase.sqlite";
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connection établie avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while (result.next()) {
                String userFirstName = result.getString("user_firstName");
                String userLastName = result.getString("user_lastName");
                String userEmail = result.getString("user_email");
                String userPassword = result.getString("user_password");
                String userName = result.getString("user_name");
                String userRole = result.getString("user_type");

                users.add(new User(userFirstName, userLastName, userEmail, userPassword, userName, userRole));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
        }
        return users;
    }

    public boolean connectionIsEstablished() {
        return connection != null;
    }

    public boolean sendUser(User user) {
        String query = "INSERT INTO user (user_firstName, user_lastName, user_name, user_email, user_password, user_type) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion de l'utilisateur : " + e.getMessage());
            return false;
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée avec succès");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}
