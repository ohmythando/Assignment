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
          Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input
        login login = new login(); // Create a login object to handle user registration and login

        // Infinite loop to keep showing the menu until the user exits
        while (true) {
            // Display menu options to the user
            System.out.println("\n1. Register"); // Option to register a new user
            System.out.println("2. Login"); // Option to log in as an existing user
            System.out.println("3. Exit"); // Option to exit the program
            System.out.print("Choose an option: "); // Prompt the user to select an option

            int choice = scanner.nextInt(); // Read the user's choice as an integer
            scanner.nextLine(); // Consume the newline character left by nextInt()

            // Perform different actions based on the user's choice
            switch (choice) {
                case 1: // User chooses to register
                    // Ask for user details during registration
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine(); // Read the username
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine(); // Read the password
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine(); // Read the first name
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine(); // Read the last name

                    // Call the registerUser method to register the user and store the result
                    String registrationResult = login.registerUser(username, password, firstName, lastName);
                    System.out.println(registrationResult); // Display the result of the registration
                    break;

                case 2: // User chooses to log in
                    // Ask for login credentials
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine(); // Read the username
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine(); // Read the password

                    // Call the returnLoginStatus method to check login details and store the result
                    String loginResult = login.returnLoginStatus(loginUsername, loginPassword);
                    System.out.println(loginResult); // Display the result of the login attempt
                    break;

                case 3: // User chooses to exit
                    System.out.println("Exiting the program. Goodbye!"); // Display exit message
                    scanner.close(); // Close the Scanner to release resources
                    System.exit(0); // Exit the program

                default: // If the user enters an invalid option
                    System.out.println("Invalid option. Please try again."); // Show error message
            }
        }
    }
}