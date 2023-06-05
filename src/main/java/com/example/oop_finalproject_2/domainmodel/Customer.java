package com.example.oop_finalproject_2.domainmodel;

public class Customer {
    private static String username;
    private static String password;
    private static String email;
    private static int userId;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Customer.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Customer.password = password;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Customer.email = email;
    }

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        Customer.userId = userId;
    }
}
