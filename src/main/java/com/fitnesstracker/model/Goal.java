package com.fitnesstracker.model;

public class Goal {

    private String description;
    private int targetCalories;
    private boolean achieved;

    public Goal(String description, int targetCalories) {
        this.description = description;
        this.targetCalories = targetCalories;
        this.achieved = false;
    }

    public String getDescription() {
        return description;
    }

    public int getTargetCalories() {
        return targetCalories;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void markAchieved() {
        this.achieved = true;
    }
}