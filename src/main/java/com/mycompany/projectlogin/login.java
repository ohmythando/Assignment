/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectlogin;

/**
 *
 * @author thand
 */
class login {
    // declarations with private classes
    private String username;
    private String password;
    private String firstname;
    private String lastname;

 public login (String username,String password,
    String firstsname, String lastname){ 
        this.username= username;
        this.password= password;
        this.firstname = firstname;
        this.lastname= lastname;
                
    }
 public login (){
                }
 // Assign each variable with the correct  parameter
 public void setFirstName(String firstName) {
    this.firstname = firstName; 
}
public void setLastName(String lastName) {
    this.lastname = lastName;
}
// a Return statement is required  for the firstname 
 public String getFirstName() {
    return this.firstname;
}
//a return statement is required  for the lastname
public String getLastName() {
    return this.lastname;
}
// a return statement is required for the username
public String getUsername() {
    return this.username;
}
//Setters are then required for each field(username,firstname,lastname)
public void setUsername(String username) {
    this.username = username;
}
public String getPassword() {
    return this.password;
}
public void setPassword(String password) {
    this.password = password;
}
// Boolean that checks is the username contains required fields
public boolean checkusername(){
return username.contains("_") && username.length() <=5;
}

// a Boolean is required to  check  the password meets the requirement
public boolean checkPasswordcomplexity() {
  // Requirements one uppercase letter, one number, and one special character
    return password.length() >= 8 &&
           password.matches(".[A-Z].") && 
           password.matches(".[0-9].") && 
           password.matches(".[!@#$%^&()_+-=].*"); 
}

//Make use of  if to return  and dispaly messages 
 public String registerUser() {
        if (!checkusername()) {
            //return and display message
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordcomplexity()) {
            //return and display message 
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        //display message
        return "Username successfully captured\nPassword successfully captured";
    }
 //make use of a boolean to return statements according to the set conditions 
 public boolean loginUser(String username,String password){
 return this.username.equals(username) && 
         this.password.equals(password);
         }
 
 public String returnLoginStatus(boolean loginStatus){
     if (loginStatus){
         // display message
     return "Welcome " + firstname + ", " + lastname + " It is great to see you again.";
 }
     //display message
    return "Username or password incorrect, please try again";
 }
 public void CreatAccount(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        //display message 
        System.out.println("Account created successfully!");
 }
}

