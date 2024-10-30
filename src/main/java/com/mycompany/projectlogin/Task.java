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
    // Task attribute private  declarations
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    /**
     * Validates task description length
     * @return true if description is within limit, false otherwise
     */
    public boolean checkTaskDescription() {
        return this.taskDescription.length() <= 50;
    }

    /**
     * Generates unique task ID based on task and developer details
     * @return formatted task ID string
     */
    public String createTaskID() {
        String taskNamePrefix = taskName.substring(0, 2).toUpperCase();
        String developerSuffix = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskNamePrefix + ":" + taskNumber + ":" + developerSuffix;
    }

    /**
     * Formats task details for display
     * @return formatted string containing all task details
     */
    public String printTaskDetails() {
        return "Task Status: " + this.taskStatus + "\n" +
               "Developer Details: " + this.developerDetails + "\n" +
               "Task Number: " + this.taskNumber + "\n" +
               "Task Name: " + this.taskName + "\n" +
               "Task Description: " + this.taskDescription + "\n" +
               "Task ID: " + this.taskID + "\n" +
               "Task Duration: " + this.taskDuration + " hours\n";
    }

    /**
     * Returns the task duration
     * @return task duration in hours
     */
    public int returnTotalHours() {
        return this.taskDuration;
    }

    // Setter methods to initialize task attributes
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
//Setter TaskNumber 
    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }
//Setter TaskDescription 
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
//Setter Developer details
    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }
//Setter Task duration
    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }
    //Setter Task Staus

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
//Setter Task ID
    public void setTaskID(String taskID) {
        this.taskID = taskID;
       
    }
     
     
    public String getTaskStatus() {
        return this.taskStatus;
}
}
    