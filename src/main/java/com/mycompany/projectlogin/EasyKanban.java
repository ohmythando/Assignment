/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectlogin;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author thand
 */
public class EasyKanban {
       // Declare ArrayList to store tasks (use lowercase for variable names)
    private final ArrayList<Task> taskList = new ArrayList<>();
    // Track total task duration
    private int totalTaskDuration = 0;

    /**
     * Main method to start the application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Create object of EasyKanban to run the application
        EasyKanban kanbanApp = new EasyKanban();
        // Create an object of login class
        login userlogin = new login();

        // Create a registration process 
        String firstName = JOptionPane.showInputDialog("Please enter your first name:");
        String lastName = JOptionPane.showInputDialog("Please enter your last name:");
        String username = JOptionPane.showInputDialog("Please enter a username (max 5 characters, must contain '_'):");
        String password = JOptionPane.showInputDialog("Please enter a password (min 8 characters, must contain a capital letter, a number, and a special character):");
        

        // Creating the account
        userlogin.createAccount(username, password, firstName, lastName);
        String registrationStatus = userlogin.registerUser();

        // Display registration status
        JOptionPane.showMessageDialog(null, registrationStatus);

        // If registration is successful, proceed to login
        if (registrationStatus.contains("successfully")) {
            boolean loginSuccessful = false;
            while (!loginSuccessful) {
                String loginUsername = JOptionPane.showInputDialog("Please enter your username to login:");
                String loginPassword = JOptionPane.showInputDialog("Please enter your password:");

                // Validate login credentials
                loginSuccessful = userlogin.loginUser(loginUsername, loginPassword);
                String loginMessage = userlogin.returnLoginStatus(loginSuccessful);

                // Show login status
                JOptionPane.showMessageDialog(null, loginMessage);

                if (!loginSuccessful) {
                    int retry = JOptionPane.showConfirmDialog(null, "Do you want to try again?", "Login Failed", JOptionPane.YES_NO_OPTION);
                    if (retry == JOptionPane.NO_OPTION) {
                        return; // Exit if user doesn't want to retry login
                    }
                }
            }

            // If login is successful, run the Kanban application
            kanbanApp.run();
        }
    }

    /**
     * Runs the main Kanban functionality
     */
    public void run() {
        // Display welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Menu loop
        boolean running = true;
        while (running) {
            String menu = JOptionPane.showInputDialog("""
                Please choose an option:
                1. Add tasks
                2. Show report
                3. Quit""");
            
            switch (menu) {
                case "1" -> addTasks();
                case "2" -> showReport();
                case "3" -> running = false;
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }

    /**
     * Adds tasks to the Kanban system
     */
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
            
            task.setTaskNumber(i);
            task.setDeveloperDetails(JOptionPane.showInputDialog("Enter developer first and last name:"));
            task.setTaskDuration(Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:")));
            
            String[] statusOptions = {"To Do", "Doing", "Done"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, 
                "Choose task status", 
                "Task Status",
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                statusOptions, 
                statusOptions[0]);
            task.setTaskStatus(taskStatus);
            
            // Generate and set task ID
            task.setTaskID(task.createTaskID());

            // Add task to list and update total duration
            taskList.add(task);
            totalTaskDuration += task.returnTotalHours();
            
            // Display task details
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }
        
        // Display total duration after all tasks are entered
        JOptionPane.showMessageDialog(null, "Total task duration: " + totalTaskDuration + " hours");
    }

    /**
     * Displays a report of all tasks in the system
     */
    private void showReport() {
        if (taskList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks have been added yet.");
            return;
        }

        StringBuilder report = new StringBuilder("Task Report:\n\n");
        
        // Add task count and total duration
        report.append("Total number of tasks: ").append(taskList.size()).append("\n");
        report.append("Total duration of all tasks: ").append(totalTaskDuration).append(" hours\n\n");
        
        // Group tasks by status
        int todoCount = 0;
        int doingCount = 0;
        int doneCount = 0;
        
        for (Task task : taskList) {
            switch (task.getTaskStatus()) {
                case "To Do" -> todoCount++;
                case "Doing" -> doingCount++;
                case "Done" -> doneCount++;
            }
        }
        
        // Add status summary
        report.append("Tasks by Status:\n");
        report.append("To Do: ").append(todoCount).append("\n");
        report.append("Doing: ").append(doingCount).append("\n");
        report.append("Done: ").append(doneCount).append("\n\n");
        
        // Add details for each task
        report.append("Task Details:\n");
        for (Task task : taskList) {
            report.append("-------------------\n");
            report.append(task.printTaskDetails());
        }
        
        JOptionPane.showMessageDialog(null, report.toString());
    }
}