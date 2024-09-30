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
           //  make use of a boolean to have true or false options 
        boolean isAccountCreated = false;

        System.out.println("Please register an account");
//  Asking for valid creditienials  details with use of a while loop
        while (!isAccountCreated) {
            //Prompts for their credentials (firstname,lastname,usernameand password)
            System.out.print("Enter first name: ");
            String firstName = sc.nextLine();
            system.setFirstName(firstName);
            System.out.print("Enter last name: ");
            String lastName = sc.nextLine();
            system.setLastName(lastName);
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            system.setUsername(username);
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            system.setPassword(password);
           
        // Make use of if statements  
            String registrationStatus = system.registerUser();
            System.out.println(registrationStatus); 
            if (registrationStatus.contains("successfully")) {
                system.CreatAccount(username, password, firstName, lastName);
                isAccountCreated = true;
            }
        }
// continue to login  into account if setup  is successful
        System.out.println("Login:");
        System.out.print("Enter username: ");
        String loginUsername = sc.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = sc.nextLine();
// attempt  to  login onto system
        boolean loginStatus = system.loginUser(loginUsername, loginPassword);
       
        // Display login status message to user.
        String loginMessage = system.returnLoginStatus(loginStatus);
        System.out.println(loginMessage);
    }
}
