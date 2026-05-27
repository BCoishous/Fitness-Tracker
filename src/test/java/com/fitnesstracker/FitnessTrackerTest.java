package com.fitnesstracker;

import com.fitnesstracker.model.Workout;
import com.fitnesstracker.model.Goal;
import com.fitnesstracker.service.FitnessTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FitnessTrackerTest {

    private FitnessTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new FitnessTracker();
    }

    @Test
    void testLogWorkoutIncreasesCount() {
        tracker.logWorkout(new Workout("Running", 30, 300));
        assertEquals(1, tracker.getWorkoutCount());
    }

    @Test
    void testTotalCaloriesBurned() {
        tracker.logWorkout(new Workout("Running", 30, 300));
        tracker.logWorkout(new Workout("Cycling", 45, 400));
        assertEquals(700, tracker.getTotalCaloriesBurned());
    }

    @Test
    void testTotalDurationMinutes() {
        tracker.logWorkout(new Workout("Running", 30, 300));
        tracker.logWorkout(new Workout("Cycling", 45, 400));
        assertEquals(75, tracker.getTotalDurationMinutes());
    }

    @Test
    void testNoWorkoutsInitially() {
        assertEquals(0, tracker.getWorkoutCount());
    }

    @Test
    void testNoCaloriesInitially() {
        assertEquals(0, tracker.getTotalCaloriesBurned());
    }

    @Test
    void testGoalAchievedWhenCaloriesMet() {
        tracker.logWorkout(new Workout("Running", 60, 600));
        tracker.addGoal(new Goal("Burn 500 calories", 500));
        tracker.checkGoals();
        assertTrue(tracker.getGoals().get(0).isAchieved());
    }

    @Test
    void testGoalNotAchievedWhenCaloriesNotMet() {
        tracker.logWorkout(new Workout("Walking", 20, 100));
        tracker.addGoal(new Goal("Burn 500 calories", 500));
        tracker.checkGoals();
        assertFalse(tracker.getGoals().get(0).isAchieved());
    }

    @Test
    void testMultipleWorkoutsCount() {
        tracker.logWorkout(new Workout("Running", 30, 300));
        tracker.logWorkout(new Workout("Cycling", 45, 400));
        tracker.logWorkout(new Workout("Swimming", 60, 500));
        assertEquals(3, tracker.getWorkoutCount());
    }

    @Test
    void testWorkoutTypeIsStored() {
        tracker.logWorkout(new Workout("Yoga", 30, 150));
        assertEquals("Yoga", tracker.getWorkouts().get(0).getType());
    }

    @Test
    void testGoalIsNotAchievedByDefault() {
        tracker.addGoal(new Goal("Burn 300 calories", 300));
        assertFalse(tracker.getGoals().get(0).isAchieved());
    }

    @Test
    void testMultipleGoalsTracked() {
        tracker.addGoal(new Goal("Burn 300 calories", 300));
        tracker.addGoal(new Goal("Burn 500 calories", 500));
        assertEquals(2, tracker.getGoals().size());
    }
}