package com.example.oop_finalproject_2.purchaseticket;

import com.example.oop_finalproject_2.SeatManager;
import javafx.scene.control.Button;

public class ButtonColorChanger {

    public static void addColorChangeEffect(Button button, SeatManager seatManager) {
        button.setOnAction(event -> toggleButtonColor(button, seatManager));
    }

    private static void toggleButtonColor(Button button, SeatManager seatManager) {
        if (seatManager.isSeatSelected(button)) {
            seatManager.unselectSeat(button);
        } else {
            seatManager.selectSeat(button);
        }
        updateButtonStyle(button, seatManager.isSeatSelected(button));
        seatManager.printSelectedSeats();
    }

    private static void updateButtonStyle(Button button, boolean isSelected) {
        if (isSelected) {
            button.setStyle("-fx-background-color: #98fb98;");
        } else {
            button.setStyle("");
        }
    }
}

