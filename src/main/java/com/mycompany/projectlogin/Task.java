    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectlogin;

/**
 *
 * @author thand
 */
public final class Task {

    // Fields to store information about a task
    private final String taskName; // The name of the task
    private final int taskNumber; // A unique number for each task
    private final String taskDescription; // A short description of the task
    private final String developerDetails; // Name or details of the developer working on the task
    private final int taskDuration; // How long the task will take, in hours
    private final String taskID; // A unique ID for the task, generated automatically
    private final String taskStatus; // The current status of the task (e.g., "To Do", "In Progress", "Done")

    // Shared variables for all tasks
    private static int taskCounter = 0; // Keeps track of how many tasks have been created
    private static int totalHours = 0; // Adds up the time of all tasks

    // Constructor to create a new Task object
    public Task(String taskName, String taskDescription, String developerDetails, 
                int taskDuration, String taskStatus) {
        this.taskName = taskName; // Set the task name
        this.taskNumber = taskCounter++; // Assign a number to this task and increase the counter
        this.taskDescription = taskDescription; // Set the task description
        this.developerDetails = developerDetails; // Set the developer's details
        this.taskDuration = taskDuration; // Set how long the task will take
        this.taskStatus = taskStatus; // Set the current status of the task
        this.taskID = createTaskID(); // Generate a unique ID for the task
        totalHours += taskDuration; // Add this task's duration to the total
    }

    // Method to check if the task description is not too long
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50; // True if description is 50 characters or less
    }

    // Method to create a unique task ID
    public String createTaskID() {
        String[] devNames = developerDetails.split(" "); // Split the developer's name into parts
        String lastName = devNames[devNames.length - 1]; // Get the last part of the developer's name
        // Create the ID using the first 2 letters of the task name, task number, and last 3 letters of the last name
        return (taskName.substring(0, 2) + ":" + taskNumber + ":" + 
                lastName.substring(lastName.length() - 3)).toUpperCase();
    }

    // Method to display all the task details as a single formatted string
    public String printTaskDetails() {
        return String.format("""
            Task Status: %s
            Developer Details: %s
            Task Number: %d
            Task Name: %s
            Task Description: %s
            Task ID: %s
            Duration: %d hours""", 
            taskStatus, developerDetails, taskNumber, 
            taskName, taskDescription, taskID, taskDuration);
    }

    // Method to get the total time of all tasks
    public static int returnTotalHours() {
        return totalHours; // Return the sum of all task durations
    }

    // Method to reset the task counter and total hours (useful for testing or starting over)
    public static void resetTaskCounter() {
        taskCounter = 0; // Reset the counter to 0
        totalHours = 0; // Reset the total time to 0
    }
}