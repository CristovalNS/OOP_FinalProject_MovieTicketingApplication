package com.example.oop_finalproject_2.purchaseticket;

import com.example.oop_finalproject_2.SeatManager;
import com.example.oop_finalproject_2.SeatSelection;
import javafx.scene.control.Button;

public class ButtonColorChanger {

    //TODO: Might be redundant. Marked for potential removal.
    public static void addColorChangeEffect(Button button, SeatManager seatManager) {
        button.setOnAction(event -> toggleButtonColor(button, seatManager));
    }

    public static void toggleButtonColor(Button button, SeatManager seatManager) {
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

