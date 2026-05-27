package com.fitnesstracker.model;

import java.util.ArrayList;
import java.util.List;

public class FitnessLog {

    private List<Workout> workouts;

    public FitnessLog() {
        this.workouts = new ArrayList<>();
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public int getTotalCaloriesBurned() {
        int total = 0;
        for (Workout workout : workouts) {
            total += workout.getCaloriesBurned();
        }
        return total;
    }

    public int getTotalDurationMinutes() {
        int total = 0;
        for (Workout workout : workouts) {
            total += workout.getDurationMinutes();
        }
        return total;
    }

    public int getWorkoutCount() {
        return workouts.size();
    }
}