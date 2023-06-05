package com.example.oop_finalproject_2.controller;

import com.example.oop_finalproject_2.DBUtils;
import com.example.oop_finalproject_2.domainmodel.Reservation;
import com.example.oop_finalproject_2.domainmodel.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseHistory_Controller {
    public static void checkPurchaseHistory() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
            String query = "SELECT * FROM reservation_data_1 WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, DBUtils.getUserId(Customer.getUsername()));

            List<Reservation> reservations = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setMovie_title(resultSet.getString("movie_title"));
                reservation.setSeat_number(resultSet.getString("seat_number"));
                reservation.setReservation_date(resultSet.getString("reservation_date"));
                reservation.setReservation_time(resultSet.getString("reservation_time"));
                reservations.add(reservation);
            }

            // Debug
            for (Reservation reservation : reservations) {
                System.out.println(reservation.getMovie_title());
                System.out.println(reservation.getSeat_number());
                System.out.println(reservation.getReservation_date());
                System.out.println(reservation.getReservation_time());
            }


            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Reservation> getReservations() {
        List<Reservation> reservations = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingData", "root", "*neoSQL01")) {
            String query = "SELECT * FROM reservation_data_1 WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, DBUtils.getUserId(Customer.getUsername()));

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setMovie_title(resultSet.getString("movie_title"));
                reservation.setSeat_number(resultSet.getString("seat_number"));
                reservation.setReservation_date(resultSet.getString("reservation_date"));
                reservation.setReservation_time(resultSet.getString("reservation_time"));
                reservations.add(reservation);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }
}
