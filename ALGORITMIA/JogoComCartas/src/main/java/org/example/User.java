package org.example;

public class User {
    int id;
    String username;
    String email;
    String password;
    boolean auth;

    public User() {
        username = "Visitante";
    }

    void login(String newUsername, String newPassword){
        username = "Fabio";
        password = "12345";

        auth = (username.equals(newUsername) && password.equals(newPassword));

        if (auth){
            System.out.println("Bem Vindo " + username);
        }else {
            System.out.println("Invalid User");
        }
    }

    void logout(){

    }

    void registe(){

    }
}
