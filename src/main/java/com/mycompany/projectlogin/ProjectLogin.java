/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projectlogin;

import java.util.Scanner;

/**
 *
 * @author thand
 */
public class ProjectLogin {

    public static void main(String[] args) {
          login system = new login();
        
        Scanner sc = new Scanner(System.in);
        // Use a boolean for true or false options 
        boolean isAccountCreated = false;
        System.out.println("Please register an account");
        // Ask for credentials details with the use of a while loop
        while (!isAccountCreated) {
            //firstName
            System.out.print("Enter first name: ");
            system.firstName = sc.nextLine();
            //lastName
            System.out.print("Enter last name: ");
            system.lastName = sc.nextLine();
            //username
            System.out.print("Enter username: ");
            system.username = sc.nextLine();
            //Password
            System.out.print("Enter password: ");
            system.password = sc.nextLine();

            // Use if statements to set the account creation status to true   
            String registrationStatus = system.registerUser();
            System.out.println(registrationStatus);
            if (registrationStatus.contains("successfully")) {
                system.createAccount(system.username, system.password, system.firstName, system.lastName);
                isAccountCreated = true;
            }
        }
 
        // Continue to log into the account when login is successful
        System.out.println("Login:");
        // Use a boolean to track login status
        boolean loginStatus = false;
        // Use a while loop to continously prompt the users  login attempts
        while (!loginStatus) {
            System.out.print("Enter username: ");
            String loginUsername = sc.nextLine();
            System.out.print("Enter password: ");
            String loginPassword = sc.nextLine();

            // Attempt to log into the system
            loginStatus = system.loginUser(loginUsername, loginPassword);

            // Display message based on login attempt result
            String loginMessage = system.returnLoginStatus(loginStatus);
            System.out.println(loginMessage);
        }
    }
}
     