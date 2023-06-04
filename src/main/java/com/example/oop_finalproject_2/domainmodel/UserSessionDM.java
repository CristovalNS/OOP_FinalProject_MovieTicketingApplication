package com.example.oop_finalproject_2.domainmodel;

public class UserSessionDM {
    protected static String username;
    protected static String password;
    protected static String email;
    protected static int userId;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserSessionDM.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserSessionDM.password = password;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserSessionDM.email = email;
    }

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        UserSessionDM.userId = userId;
    }
}
