package com.example.oop_finalproject_2.domainmodel;

public class ReservationDM {
    // Attributes
    private String reservation_id;
    private String user_id;
    private String movie_title;
    private String seat_number;
    private String reservation_date;
    private String reservation_time;

    // Methods
    public void setReservation_id(String reservation_id) {
        this.reservation_id = reservation_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }

    public void setReservation_date(String reservation_date) {
        this.reservation_date = reservation_date;
    }

    public void setReservation_time(String reservation_time) {
        this.reservation_time = reservation_time;
    }

    public String getReservation_id() {
        return reservation_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public String getReservation_date() {
        return reservation_date;
    }

    public String getReservation_time() {
        return reservation_time;
    }
}
