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
    // private declarations
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
 // Assign each variable with its correct  parameter
 public void setFirstName(String firstname) {
    this.firstname = firstname; 
}
public void setLastName(String lastname) {
    this.lastname = lastname;
} 
 public String getFirstName() {
    return this.firstname;
}
 //getters
 
public String getLastName() {
    return this.lastname;
}
public String getusername() {
    return this.username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getPassword() {
    return this.password;
}
public void setPassword(String password) {
    this.password = password;
}

//use a boolean that checks requirements 
public boolean checkusername(){
return username.contains("_") && username.length() <=5;
}
// make use of a Boolean  to  check  that requirements are met 
   public boolean checkPasswordComplexity() {
    // Set parameters  Check for at least one uppercase letter, one number, and one special character
    return password.length() >= 8 &&
           password.matches(".*[A-Z].*") && 
           password.matches(".*[0-9].*") && 
           password.matches(".*[!@#$%^&*()_+-=].*"); 
}
//Make use of  if  statements to return  and display messages 
     public String registerUser() {
        if (!checkusername()) {
           //return and display
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity()) {
             //return and display
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        } 
         //return and display
        return "Username successfully captured\nPassword successfully captured";
    }
 //make use of a boolean to return statements with the set  conditions 
    public boolean loginuser(String username,String password){
        return this.username.equals(username) && 
         this.password.equals(password);
         }
 public String returnLoginStatus(boolean loginStatus){
     if (loginStatus){
         // return and display message
     return "Welcome " + firstname + ", " + lastname + " It is great to see you again.";
 }
     // return and display message
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
