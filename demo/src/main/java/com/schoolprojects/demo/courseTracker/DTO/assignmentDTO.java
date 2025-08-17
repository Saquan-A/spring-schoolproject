package com.schoolprojects.demo.courseTracker.DTO;

import jakarta.validation.constraints.NotNull;

public class assignmentDTO {
    
    @NotNull(message = "Title cannot be null")
    private String title;
    private int maxPoints;
    private int pointsEarned;

    private String dueDate;
    @NotNull(message = "Description cannot be null")
    private String description;

    public assignmentDTO(String title, int maxPoints, int pointsEarned, String dueDate, String description) {
        this.title = title;
        this.maxPoints = maxPoints;
        this.pointsEarned = pointsEarned;
        this.dueDate = dueDate;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }
    public int getMaxPoints() {
        return maxPoints;
    }
    public int getPointsEarned() {
        return pointsEarned;
    }
    public String getDueDate() {
        return dueDate;
    }
    public String getDescription() {
        return description;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
