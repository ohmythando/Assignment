/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectlogin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thand
 */
public class login {
   // List to store all registered users
    private final List<User> users;

    // Constructor to initialize the list of users
    public login() {
        this.users = new ArrayList<>();
    }

    /**
     * Checks if the username meets the required format:
     * - Contains an underscore
     * - Is no more than 5 characters long
     * @param username
     * @return 
     */
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Checks if the password meets complexity requirements:
     * - At least 8 characters long
     * - Contains at least one capital letter
     * - Contains at least one number
     * - Contains at least one special character
     * @param password
     * @return 
     */
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") && // Check for uppercase letters
               password.matches(".*\\d.*") && // Check for digits
               password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*"); // Check for special characters
    }

    /**
     * Registers a new user if the username and password meet the requirements.
     * Returns a success or error message based on the input validity.
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @return 
     */
    public String registerUser(String username, String password, String firstName, String lastName) {
        // Check if the username is valid
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        // Check if the password is valid
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        // Add the new user to the list
        users.add(new User(username, password, firstName, lastName));
        return "Username successfully captured\nPassword successfully captured";
    }

    /**
     * Checks if the provided username and password match any registered user.
     * Returns true if a match is found, false otherwise.
     * @param username
     * @param password
     * @return 
     */
    public boolean loginUser(String username, String password) {
        for (User user : users) { // Loop through all users
            // Check if username and password match
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false; // No match found
    }

    /**
     * Returns a message indicating the login status:
     * - Success: Welcome message with user's first and last name
     * - Failure: Error message indicating incorrect credentials
     * @param username
     * @param password
     * @return 
     */
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) { // Check if login is successful
            User user = getUserByUsername(username); // Get the user details
            return "Welcome " + user.getFirstName() + ", " + user.getLastName() + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again";
        }
    }

    /**
     * Returns a user object based on their username.
     * Returns the user if found, null otherwise.
     */
    private User getUserByUsername(String username) {
        for (User user : users) { // Loop through all users
            if (user.getUsername().equals(username)) { // Check if the username matches
                return user;
            }
        }
        return null; // User not found
    }

    /**
     * Declare variables private
     * - Username
     * - Password
     * - First name
     * - Last name
     */
    private static class User {
        private final String username; // Stores the user's username
        private final String password; // Stores the user's password
        private final String firstName; // Stores the user's first name
        private final String lastName; // Stores the user's last name

        // Constructor to initialize user details
        public User(String username, String password, String firstName, String lastName) {
            this.username = username;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // Getter methods to retrieve user details:
        //get username
        public String getUsername() { return username; }
        //get password
        public String getPassword() { return password; }
        //get firstname
        public String getFirstName() { return firstName; }
        //get lastname
        public String getLastName() { return lastName; }
    }
}