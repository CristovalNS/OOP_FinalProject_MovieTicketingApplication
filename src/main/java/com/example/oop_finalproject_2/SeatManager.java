package com.example.oop_finalproject_2;

import javafx.scene.control.Button;

import java.util.HashSet;
import java.util.Set;

public class SeatManager {
    private static Set<Button> selectedSeats;

    public SeatManager() {
        selectedSeats = new HashSet<>();
    }

    public void selectSeat(Button seatButton) {
        seatButton.setStyle("-fx-background-color: green;");
        selectedSeats.add(seatButton);
    }

    public void unselectSeat(Button seatButton) {
        seatButton.setStyle("");
        selectedSeats.remove(seatButton);
    }

    public boolean isSeatSelected(Button seatButton) {
        return selectedSeats.contains(seatButton);
    }

    public static void printSelectedSeats() {
        System.out.print("Selected seats: ");
        for (Button seatButton : selectedSeats) {
            System.out.print(seatButton.getText() + ", ");
        }
        System.out.println();
    }

    public static int getTotalSelectedSeats() {
        return selectedSeats.size();
    }
}
