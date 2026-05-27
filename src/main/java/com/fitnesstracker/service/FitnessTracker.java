package com.fitnesstracker.service;

import com.fitnesstracker.model.FitnessLog;
import com.fitnesstracker.model.Goal;
import com.fitnesstracker.model.Workout;

import java.util.ArrayList;
import java.util.List;

public class FitnessTracker {

    private FitnessLog log;
    private List<Goal> goals;

    public FitnessTracker() {
        this.log = new FitnessLog();
        this.goals = new ArrayList<>();
    }

    public void logWorkout(Workout workout) {
        log.addWorkout(workout);
    }

    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    public int getTotalCaloriesBurned() {
        return log.getTotalCaloriesBurned();
    }

    public int getTotalDurationMinutes() {
        return log.getTotalDurationMinutes();
    }

    public int getWorkoutCount() {
        return log.getWorkoutCount();
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void checkGoals() {
        for (Goal goal : goals) {
            if (log.getTotalCaloriesBurned() >= goal.getTargetCalories()) {
                goal.markAchieved();
            }
        }
    }

    public List<Workout> getWorkouts() {
        return log.getWorkouts();
    }
}