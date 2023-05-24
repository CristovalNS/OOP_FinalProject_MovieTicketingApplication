package com.example.oop_finalproject_2.purchaseconfirm;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.SeatManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PurchaseConfirmMovieP1 extends BasePurchaseConfirmTemplateController implements Initializable {

    @FXML
    private Label seat_test;

    @FXML
    private Button button_return;

    private SeatManager seatManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle); // Call the initialize method of the parent class to set the button cursors

        seatManager = new SeatManager();
        updateSelectedSeatsLabel();

        button_return.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "purchase-ticket-movie-P1.fxml", "<APP NAME> - Guardians of The Galaxy Vol 3", null, null);
            }
        });
    }

    public void updateSelectedSeatsLabel() {
        seatManager.printSelectedSeats(); // Call the printSelectedSeats() method of the SeatManager
        seat_test.setText("Selected seats: " + seatManager.getSelectedSeats()); // Set the label text to the selected seats
    }
}
