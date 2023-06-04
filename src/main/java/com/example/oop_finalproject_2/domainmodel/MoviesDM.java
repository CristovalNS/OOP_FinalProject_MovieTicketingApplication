package com.example.oop_finalproject_2.domainmodel;

public class MoviesDM {
    // Attributes
    private String movie_id;
    private String movie_title;
    private String movie_availability;
    private String movie_schedule;
    private String release_date;
    private String movie_genre;
    private String movie_director;
    private String movie_cast;
    private String movie_duration;
    private String movie_description;
    private String movie_poster;

    // Methods
    public void setMovie_id(String movieId) {
        this.movie_id = movieId;
    }

    public void setMovie_title(String movieTitle) {
        this.movie_title = movieTitle;
    }

    public void setMovie_availability(String movieAvailability) {
        this.movie_availability = movieAvailability;
    }

    public void setMovie_schedule(String movieSchedule) {
        this.movie_schedule = movieSchedule;
    }

    public void setRelease_date(String releaseDate) {
        this.release_date = releaseDate;
    }

    public void setMovie_genre(String movieGenre) {
        this.movie_genre = movieGenre;
    }

    public void setMovie_director(String movieDirector) {
        this.movie_director = movieDirector;
    }

    public void setMovie_cast(String movieCast) {
        this.movie_cast = movieCast;
    }

    public void setMovie_duration(String movieDuration) {
        this.movie_duration = movieDuration;
    }

    public void setMovie_description(String movieDescription) {
        this.movie_description = movieDescription;
    }

    public void setMovie_poster(String movie_poster) {
        this.movie_poster =  movie_poster;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public String getMovie_availability() {
        return movie_availability;
    }

    public String getMovie_schedule() {
        return movie_schedule;
    }

    public String getRelease_date() { return release_date; }

    public String getMovie_genre() {
        return movie_genre;
    }

    public String getMovie_director() {
        return movie_director;
    }

    public String getMovie_cast() {
        return movie_cast;
    }

    public String getMovie_duration() {
        return movie_duration;
    }

    public String getMovie_description() {
        return movie_description;
    }

    public String getMovie_poster() { return movie_poster; }

}
