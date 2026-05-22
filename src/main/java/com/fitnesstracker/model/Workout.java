package com.fitnesstracker.model;

public class Workout {

    private String type;
    private int durationMinutes;
    private int caloriesBurned;

    public Workout(String type, int durationMinutes, int caloriesBurned) {
        this.type = type;
        this.durationMinutes = durationMinutes;
        this.caloriesBurned = caloriesBurned;
    }

    public String getType() {
        return type;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }
}