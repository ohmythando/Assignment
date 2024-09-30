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
//  Asking for creditienials  details with use of a while loop
        while (!isAccountCreated) {
            System.out.print("Enter first name: ");
            String firstname = sc.nextLine();
            system.setFirstName(firstname);
            System.out.print("Enter last name: ");
            String lastname = sc.nextLine();
            system.setLastName(lastname);
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            system.setUsername(username);
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            system.setPassword(password);
        // Make use of if statements to set statement true   
            String registrationStatus = system.registerUser();
            System.out.println(registrationStatus);
            if (registrationStatus.contains("successfully")) {
                system.CreatAccount(username, password, firstname, lastname);
                isAccountCreated = true;
            }
        }
// continue to login  into account when login is  successful
        System.out.println("Login:");
        //Make use of  a boolean 
        boolean loginStatus=false;
        //Make use of a while loop
        while(!loginStatus){
        System.out.print("Enter username: ");
        String loginUsername = sc.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = sc.nextLine();
        
// attempt  to  login into system
       loginStatus = system.loginuser(loginUsername, loginPassword);
       
        // Display  message 
        String loginMessage = system.returnLoginStatus(loginStatus);
        System.out.println(loginMessage);
    }
}
}
