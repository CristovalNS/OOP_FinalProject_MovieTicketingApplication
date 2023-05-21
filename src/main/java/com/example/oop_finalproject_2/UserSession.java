package com.example.oop_finalproject_2;

public class UserSession {
    protected static String username;
    protected static String password;
    protected static String email;
    protected static int userId;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserSession.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserSession.password = password;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserSession.email = email;
    }

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        UserSession.userId = userId;
    }
}
