/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectlogin;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author thand
 */
public class EasyKanban {
    private final login loginSystem;
    private final List<Task> tasks;//List to store the task objects 
    private boolean isLoggedIn;//Boolean to check whether or not user is logged in 
    private final List<String> developers = new ArrayList<>();
    private final List<String> taskNames = new ArrayList<>();
    private final List<String> taskIDs = new ArrayList<>();
    private final List<Integer> taskDurations = new ArrayList<>();
    private final List<String> taskStatuses = new ArrayList<>();
//Constructor 
    public EasyKanban() {
        //initialize loginsystem
        this.loginSystem = new login();
        //initialize task list
        this.tasks = new ArrayList<>();
        this.isLoggedIn = false;
    }

    public void run() {
        //while loop to display menu 
        while (true) {//loop will run until user quits 
            if (!isLoggedIn) {//Checks if user is logged in 
                int choice = Integer.parseInt(JOptionPane.showInputDialog(//diplays login and registration menu
                        """
                        1. Register
                        2. Login
                        3. Quit
                        Please select an option:"""));
//Switch case to call methods 
                switch (choice) {
                    case 1 -> registerNewUser();
                    case 2 -> login();
                    case 3 -> {
                        return;//exit the system
                    }
                }
            } else {
                showMainMenu();//display menu 
            }
        }
    }
//method to register user 
    private void registerNewUser() {
        //captures user details and their parameters
        // propmt user for username
        String username = JOptionPane.showInputDialog("Enter username (must contain underscore and be <= 5 chars):");
        // prompt user for password
        String password = JOptionPane.showInputDialog("Enter password (min 8 chars, must contain capital, number, and special char):");
        //prompt user for firstname
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        //prompt user for lastName
        String lastName = JOptionPane.showInputDialog("Enter last name:");
        String result = loginSystem.registerUser(username, password, firstName, lastName);
        JOptionPane.showMessageDialog(null, result);
    }
//method to login user
    private void login() {
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        String loginStatus = loginSystem.returnLoginStatus(username, password);
        JOptionPane.showMessageDialog(null, loginStatus);

        if (loginSystem.loginUser(username, password)) {
            isLoggedIn = true;
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        }
    }
//menu method 
    private void showMainMenu() {
        int choice = Integer.parseInt(JOptionPane.showInputDialog("""
            1. Add tasks
            2. Show report
            3. Display tasks with status 'Done'
            4. Display task with longest duration
            5. Search for task
            6. Delete task
            7. Quit
            Choose an option:"""));
//switch to select an action 
        switch (choice) {
            case 1 -> addTasks();
            case 2 -> displayAllTasks();
            case 3 -> displayTasksWithStatusDone();
            case 4 -> displayTaskWithLongestDuration();
            case 5 -> searchForTask();
            case 6 -> deleteTask();
            case 7 -> isLoggedIn = false;
        }
    }
// method to add tasks 
    private void addTasks() {
         // User input for number of tasks
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to enter?"));

        for (int i = 0; i < numTasks; i++) {
            Task task = new Task();
            String taskDescription;
            
            // Get task details from user
            task.setTaskName(JOptionPane.showInputDialog("Enter task name:"));
            
            // Loop until valid task description is entered
            do {
                taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
                task.setTaskDescription(taskDescription);
                
                if (taskDescription.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                } else {
                    JOptionPane.showMessageDialog(null, "Task successfully captured");
                    break;
                }
            } while (taskDescription.length() > 50);
            ask.setTaskNumber(i);
            task.setDeveloperDetails(JOptionPane.showInputDialog("Enter developer first and last name:"));
            JOptionPane.showMessageDialog(null,
                    "Task successfully captured\n\n" + task.printTaskDetails());
        }

        JOptionPane.showMessageDialog(null,
                "Total hours for all tasks: " + Task.returnTotalHours());
    }
//Display task with the status "Done"
    private void displayTasksWithStatusDone() {
        StringBuilder result = new StringBuilder("Tasks with 'Done' Status:\n");

        for (int i = 0; i < taskStatuses.size(); i++) {
            if ("Done".equalsIgnoreCase(taskStatuses.get(i))) {
                result.append(String.format("Task: %s, Developer: %s%n", taskNames.get(i), developers.get(i)));
            }
        }

        JOptionPane.showMessageDialog(null, result.toString());
    }
//Display task with the longest duration 
    private void displayTaskWithLongestDuration() {
        int maxDuration = 0;
        int index = -1;
//for loop duration to find the max duration hours 
        for (int i = 0; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > maxDuration) {
                maxDuration = taskDurations.get(i);
                index = i;
            }
        }
//if statement to diplay the task 
        if (index != -1) {
            JOptionPane.showMessageDialog(null,
                    String.format("Developer: %s, Duration: %d hours",
                            developers.get(index), maxDuration));
        }
    }
//method to search for a task 
    private void searchForTask() {
        String searchCriteria = JOptionPane.showInputDialog("Enter task name or developer to search:");

        StringBuilder result = new StringBuilder("Search Results:\n");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(searchCriteria) || developers.get(i).equalsIgnoreCase(searchCriteria)) {
                result.append(String.format("Developer: %s, Task: %s, Duration: %d hours, Status: %s%n",
                        developers.get(i), taskNames.get(i), taskDurations.get(i), taskStatuses.get(i)));
            }
        }
//Display search results
        JOptionPane.showMessageDialog(null, result.toString());
    }
//delete task by its name 
    private void deleteTask() {
        String taskToDelete = JOptionPane.showInputDialog("Enter the task name to delete:");
//option to remove deatils 
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskToDelete)) {
                developers.remove(i);
                taskNames.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                JOptionPane.showMessageDialog(null, "Task successfully deleted.");
                return;//exit the method
            }
        }

        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    private void displayAllTasks() {
        StringBuilder result = new StringBuilder("All Tasks Report:\n");

        for (int i = 0; i < taskNames.size(); i++) {
            result.append(String.format("Task ID: %s, Developer: %s, Task: %s, Duration: %d hours, Status: %s%n",
                    taskIDs.get(i), developers.get(i), taskNames.get(i), taskDurations.get(i), taskStatuses.get(i)));
        }

        JOptionPane.showMessageDialog(null, result.toString());
    }

    public static void main(String[] args) {
        new EasyKanban().run();
    }
}
