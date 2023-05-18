/**
 * The brains of the application.
 */

package com.example.oop_finalproject_2;

import java.sql.Connection;
//import com.almasb.fxgl.net.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import java.sql.*;
import org.controlsfx.control.action.Action;

import java.io.IOException;

public class DBUtils {
    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username, String password) {
        Parent root = null;

        if (username != null && password != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                LoggedInController loggedInController = loader.getController();
                loggedInController.usernameConfirmation(username);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * The code below takes cares of the functions in regard to registering a new user.
     */
    public static void registerUser(ActionEvent event, String username, String title, String password, String confirmPassword) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExist = null;
        ResultSet resultSet = null;

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Make sure to confirm your password correctly!");

            // Set the font style for the text
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-family: Arial");

            alert.show();
        } else {
            try {
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/user-data", "root", "*neoSQL01");
                psCheckUserExist = ((java.sql.Connection) connection).prepareStatement("SELECT * FROM users WHERE username = ?");
                psCheckUserExist.setString(1, username);
                resultSet = psCheckUserExist.executeQuery();

                if (resultSet.isBeforeFirst()) {
                    System.out.println("User already exists!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("You cannot use this username");

                    // Set the font style for the text
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.setStyle("-fx-font-family: Arial");

                    alert.show();
                } else {
                    psInsert = ((java.sql.Connection) connection).prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
                    psInsert.setString(1, username);
                    psInsert.setString(2, password);
                    psInsert.executeUpdate();

                    changeScene(event, "logged-in.fxml", "Welcome!", username, password);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (psCheckUserExist != null) {
                    try {
                        psCheckUserExist.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (psInsert != null) {
                    try {
                        psInsert.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    try {
                        ((java.sql.Connection) connection).close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * The code below takes cares of the functions in regard to loging in to an existing account.
     */

    public static void logInUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/user-data", "root", "*neoSQL01");
            preparedStatement = ((java.sql.Connection) connection).prepareStatement("SELECT password FROM users WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Invalid credentials!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid credentials!");

                // Set the font style for the text
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.setStyle("-fx-font-family: Arial");

                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(password)) {
                        changeScene(event, "logged-in.fxml", "Welcome!", username, password);
                    } else {
                        System.out.println("Passwords did not match!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Invalid credentials!");

                        // Set the font style for the text
                        DialogPane dialogPane = alert.getDialogPane();
                        dialogPane.setStyle("-fx-font-family: Arial");

                        alert.show();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    ((java.sql.Connection) connection).close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
