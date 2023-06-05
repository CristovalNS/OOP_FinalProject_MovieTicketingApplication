package com.example.oop_finalproject_2.domainmodel;

import java.util.*;

public class SeatSelection {
    private static Set<String> selectedButtons;

    private static List<String> sortButtonList;

    public SeatSelection() {
        selectedButtons = new HashSet<>();
        sortButtonList = new ArrayList<>();
    }

    public void addButton(String buttonText) {
        if (!selectedButtons.contains(buttonText)) {
            selectedButtons.add(buttonText);
            sortButtonList.add(buttonText);
        } else {
            removeButton(buttonText);
        }
    }

    public void removeButton(String buttonText) {
        selectedButtons.remove(buttonText);
        sortButtonList.remove(buttonText);
    }

    public static List<String> getSelectedButtons() {
        Collections.sort(sortButtonList);
        return sortButtonList;
    }

    public static int getTotalSelectedSeats() {
        return selectedButtons.size();
    }
}
