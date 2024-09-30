/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.projectlogin;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class ProjectLoginTest {

    private login system;

    @BeforeEach
    public void setup() {
        // Initialize a new instance of Login before each test
        system = new login(); 
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        system.setUsername("kyl_1");
        assertTrue(system.checkusername()); 
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        system.setUsername("kyle!!!!!!!");
        assertFalse(system.checkusername());
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() {
        system.setPassword("Ch&&sec@ke99!"); 
        assertTrue(system.checkPasswordComplexity()); 
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        system.setPassword("password"); 
        assertFalse(system.checkPasswordComplexity());
    }

    @Test
    public void testRegisterUserValidUsernameAndPassword() {
        system.setUsername("kyl_1"); 
        system.setPassword("Ch&&sec@ke99!");
        String registrationStatus = system.registerUser();
        assertEquals("Username successfully captured\nPassword successfully captured", registrationStatus);
    }

    @Test
    public void testRegisterUserInvalidUsername() {
        system.setUsername("kyle!!!!!!!"); 
        system.setPassword("Ch&&sec@ke99!");        
        String registrationStatus = system.registerUser();
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", registrationStatus);
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        system.setUsername("kyl_1"); 
        system.setPassword("password");
        String registrationStatus = system.registerUser(); 
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", registrationStatus);
    }

    @Test
    public void testLoginSuccess() {
        system.CreatAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        assertTrue(system.loginuser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailure() {
        system.CreatAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe"); 
        assertFalse(system.loginuser("kyl_1", "wrongpassword")); 
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        system.CreatAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        assertEquals("Welcome John, Doe. It is great to see you again.", system.returnLoginStatus(true));
    }

    @Test
    public void testReturnLoginStatusFailure() {
        system.CreatAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe"); 
        assertEquals("Username or password incorrect, please try again", system.returnLoginStatus(false));
    }


}
