package com.mycompany.projectlogin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class loginTest {

    private login loginSystem;


    @Test
    void testCheckUsername_ValidUsername() {
        loginSystem.username = "user_";
        assertTrue(loginSystem.checkUsername(), "Username should be valid (contains underscore and <= 5 characters)");
    }

    @Test
    void testCheckUsername_InvalidUsername() {
        loginSystem.username = "user123";
        assertFalse(loginSystem.checkUsername(), "Username should be invalid (missing underscore or more than 5 characters)");
    }

    @Test
    void testCheckPasswordComplexity_ValidPassword() {
        loginSystem.password = "Passw0rd!";
        assertTrue(loginSystem.checkPasswordComplexity(), "Password should be valid (meets complexity requirements)");
    }

    @Test
    void testCheckPasswordComplexity_InvalidPassword() {
        loginSystem.password = "password";
        assertFalse(loginSystem.checkPasswordComplexity(), "Password should be invalid (missing uppercase, number, or special character)");
    }

    @Test
    void testRegisterUser_ValidUsernameAndPassword() {
        loginSystem.username = "user_";
        loginSystem.password = "Passw0rd!";
        assertEquals("Username successfully captured\nPassword successfully captured", loginSystem.registerUser(),
                "Registration should succeed with valid username and password");
    }

    @Test
    void testRegisterUser_InvalidUsername() {
        loginSystem.username = "user123";
        loginSystem.password = "Passw0rd!";
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.",
                loginSystem.registerUser(), "Registration should fail with invalid username");
    }

    @Test
    void testRegisterUser_InvalidPassword() {
        loginSystem.username = "user_";
        loginSystem.password = "password";
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.",
                loginSystem.registerUser(), "Registration should fail with invalid password");
    }

    @Test
    void testLoginUser_SuccessfulLogin() {
        loginSystem.createAccount("user_", "Passw0rd!", "John", "Doe");
        assertTrue(loginSystem.loginUser("user_", "Passw0rd!"), "Login should succeed with correct username and password");
    }

    @Test
    void testLoginUser_UnsuccessfulLogin() {
        loginSystem.createAccount("user_", "Passw0rd!", "John", "Doe");
        assertFalse(loginSystem.loginUser("user_", "wrongPass!"), "Login should fail with incorrect password");
    }

    @Test
    void testReturnLoginStatus_SuccessfulLogin() {
        loginSystem.firstName = "John";
        loginSystem.lastName = "Doe";
        String expectedMessage = "Welcome John Doe. It is great to see you again.";
        assertEquals(expectedMessage, loginSystem.returnLoginStatus(true), "Should return a welcome message for successful login");
    }

    @Test
    void testReturnLoginStatus_UnsuccessfulLogin() {
        String expectedMessage = "Username or password incorrect, please try again.";
        assertEquals(expectedMessage, loginSystem.returnLoginStatus(false), "Should return an error message for unsuccessful login");
    }
}


