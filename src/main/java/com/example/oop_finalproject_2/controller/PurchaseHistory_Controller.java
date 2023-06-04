package com.example.oop_finalproject_2.controller;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.domainmodel.ReservationDM;
import com.example.oop_finalproject_2.domainmodel.UserSessionDM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseHistory_Controller {
    private Connection connection;

    public static void purchaseHistoryController() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
            String query = "SELECT * FROM reservation_data_1 WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, DBUtils.getUserId(UserSessionDM.getUsername()));

            List<ReservationDM> reservationDMS = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ReservationDM reservationDM = new ReservationDM();
                reservationDM.setMovie_title(resultSet.getString("movie_title"));
                reservationDM.setSeat_number(resultSet.getString("seat_number"));
                reservationDM.setReservation_date(resultSet.getString("reservation_date"));
                reservationDM.setReservation_time(resultSet.getString("reservation_time"));
                reservationDMS.add(reservationDM);
            }

            // Debug
            for (ReservationDM reservationDM : reservationDMS) {
                System.out.println(reservationDM.getMovie_title());
                System.out.println(reservationDM.getSeat_number());
                System.out.println(reservationDM.getReservation_date());
                System.out.println(reservationDM.getReservation_time());
            }


            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ReservationDM> getReservations() {
        List<ReservationDM> reservationDMS = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
            String query = "SELECT * FROM reservation_data_1 WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, DBUtils.getUserId(UserSessionDM.getUsername()));

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ReservationDM reservationDM = new ReservationDM();
                reservationDM.setMovie_title(resultSet.getString("movie_title"));
                reservationDM.setSeat_number(resultSet.getString("seat_number"));
                reservationDM.setReservation_date(resultSet.getString("reservation_date"));
                reservationDM.setReservation_time(resultSet.getString("reservation_time"));
                reservationDMS.add(reservationDM);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservationDMS;
    }
}
