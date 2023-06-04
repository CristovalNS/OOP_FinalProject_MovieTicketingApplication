package com.example.oop_finalproject_2.purchasehistory;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.UserSession;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class PurchaseHistoryController implements Initializable {

    @FXML
    private Button button_account;

    @FXML
    private Button button_food;

    @FXML
    private Button button_movies;

    @FXML
    private Button button_purchases;

    @FXML
    private Button button_next_ticket;

    @FXML
    private Button button_previous_ticket;

    @FXML
    private Label label_date;

    @FXML
    private Label label_movie_title;

    @FXML
    private Label label_seat;

    @FXML
    private Label label_time;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Button[] buttons = {button_account, button_food, button_purchases, button_movies, button_next_ticket, button_previous_ticket};
        for (Button button : buttons) {
            button.setCursor(Cursor.HAND);
        }

        // Debug - User ID
        System.out.println("User ID = " + DBUtils.getUserId(UserSession.getUsername()));

        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
            // Create a SQL statement
            String query = "SELECT * FROM reservation_data_1 WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, DBUtils.getUserId(UserSession.getUsername()));

            List<String> movieTitleList = new ArrayList<>();
            List<String> seatNumberList = new ArrayList<>();
            List<String> movieDateList = new ArrayList<>();
            List<String> movieTimeList = new ArrayList<>();

            // Execute the query and store the ResultSet
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String data = resultSet.getString("movie_title");
                movieTitleList.add(data);
                data = resultSet.getString("seat_number");
                seatNumberList.add(data);
                data = resultSet.getString("reservation_date");
                movieDateList.add(data);
                data = resultSet.getString("reservation_time");
                movieTimeList.add(data);
            }

            for (String data : movieTitleList) {
                System.out.println(data);
            }

            for (String data : seatNumberList) {
                System.out.println(data);
            }

            for (String data : movieDateList) {
                System.out.println(data);
            }

            for (String data : movieTimeList) {
                System.out.println(data);
            }

            label_movie_title.setText(movieTitleList.get(0));
            label_seat.setText(seatNumberList.get(0));
            label_date.setText(movieDateList.get(0));
            label_time.setText(movieTimeList.get(0));

            AtomicInteger count = new AtomicInteger();

            button_next_ticket.setOnAction(actionEvent -> {
                count.addAndGet(1);

                label_movie_title.setText(movieTitleList.get(count.get()));
                label_seat.setText(seatNumberList.get(count.get()));
                label_date.setText(movieDateList.get(count.get()));
                label_time.setText(movieTimeList.get(count.get()));
            });


            button_previous_ticket.setOnAction(actionEvent -> {
                count.addAndGet(-1);

                label_movie_title.setText(movieTitleList.get(count.get()));
                label_seat.setText(seatNumberList.get(count.get()));
                label_date.setText(movieDateList.get(count.get()));
                label_time.setText(movieTimeList.get(count.get()));
            });

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        button_account.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "account.fxml", "<APP NAME> - Account", null, null);
            }
        });

        button_movies.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "main-menu.fxml", "<APP NAME> - Movies", null, null);
            }
        });


    }
}
