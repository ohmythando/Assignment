/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectlogin;

/**
 *
 * @author thand
 */
public class login {
      // Declare variables  as private to store user registration details
  String username;
   String password;
     String firstName;
   String lastName;
    private boolean isRegistered;
    
    /**
     * Constructor initializes user registration status
     */
    public login() {
        this.isRegistered = false;
    }

    //Validates username format &@return true if username meets requirements, false otherwise
     
    public boolean checkUsername() {
        if (username == null) {
            return false;
        }
        return username.contains("_") && username.length() <= 5;
    }

    // Validates password complexity requirements ,@return true if password meets complexity requirements, false otherwise
     
    public boolean checkPasswordComplexity() {
        if (password == null) {
            return false;
        }
        // Check for minimum length of 8 characters
        boolean hasLength = password.length() >= 8;
        // Check for at least one uppercase letter
        boolean hasUppercase = password.matches(".*[A-Z].*");
        // Check for at least one number
        boolean hasNumber = password.matches(".*[0-9].*");
        // Check for at least one special character
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+-=].*");

        return hasLength && hasUppercase && hasNumber && hasSpecial;
    }

    // Register a new user with provided credentials along with  @return Status message indicating registration success or failure
    public String registerUser() {
        // Check username format
        if (!checkUsername()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        
        // Check password complexity
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        
        // Set registration status to true if all validations pass
        this.isRegistered = true;
        return "Username and password successfully captured\nUser has been registered successfully!";
    }

    /**
     * Authenticate the  user login attempt
     * @param username
     * @param password
     * @parameter  username entered username
     * @parameter password entered password
     * @return true if login successful, false otherwise
     */
    public boolean loginUser(String username, String password) {
        // Check if user is registered and credentials match
        return isRegistered && 
               this.username != null && 
               this.password != null && 
               this.username.equals(username) && 
               this.password.equals(password);
    }

    /**
     * Generates login status message
     * @param loginStatus result of login attempt
     * @return appropriate message based on login status
     */
    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return String.format("Welcome %s %s. It is great to see you again.", 
                               firstName, lastName);
        }
        return "Username or password incorrect, please try again.";
    }

    /**
     * Creates a new user account with the orinally  provided details
     * @param username desired username
     * @param password desired password
     * @param firstName user's first name
     * @param lastName user's last name
     */
    public void createAccount(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Account details captured successfully!");
    }

    // Getter methods for testing purposes 
    //Getter for username
    public String getUsername() {
        //return username
        return username;
    }
    //Getter for password 
    public String getPassword() {
        //return password 
        return password;
    }
//Getter for firstName
    public String getFirstName() {
        //retuen firtName
        return firstName;
    }
//Getter for lastname
    public String getLastName() {
        //return Lastname
        return lastName;
    }

    public boolean isRegistered() {
        return isRegistered;
    }
}
