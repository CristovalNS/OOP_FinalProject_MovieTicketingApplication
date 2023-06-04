package com.example.oop_finalproject_2.view;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.controller.PurchaseHistory_Controller;
import com.example.oop_finalproject_2.domainmodel.ReservationDM;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class PurchaseHistoryView implements Initializable {

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
        List<ReservationDM> reservationDMS = PurchaseHistory_Controller.getReservations();

        Button[] buttons = {button_account, button_food, button_purchases, button_movies, button_next_ticket, button_previous_ticket};
        for (Button button : buttons) {
            button.setCursor(Cursor.HAND);
        }

        label_movie_title.setText(reservationDMS.get(0).getMovie_title());
        label_seat.setText(reservationDMS.get(0).getSeat_number());
        label_date.setText(reservationDMS.get(0).getReservation_date());
        label_time.setText(reservationDMS.get(0).getReservation_time());

        PurchaseHistory_Controller.purchaseHistoryController();

        AtomicInteger count = new AtomicInteger();

        button_next_ticket.setOnAction(actionEvent -> {
            count.addAndGet(1);

            label_movie_title.setText(reservationDMS.get(count.get()).getMovie_title());
            label_seat.setText(reservationDMS.get(count.get()).getSeat_number());
            label_date.setText(reservationDMS.get(count.get()).getReservation_date());
            label_time.setText(reservationDMS.get(count.get()).getReservation_time());
        });


        button_previous_ticket.setOnAction(actionEvent -> {
            count.addAndGet(-1);

            label_movie_title.setText(reservationDMS.get(count.get()).getMovie_title());
            label_seat.setText(reservationDMS.get(count.get()).getSeat_number());
            label_date.setText(reservationDMS.get(count.get()).getReservation_date());
            label_time.setText(reservationDMS.get(count.get()).getReservation_time());
        });

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
