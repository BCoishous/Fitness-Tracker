# Fitness Tracker

A simple Java application for tracking workouts, logging progress, and setting fitness goals. Built with clean OOP principles and tested with JUnit 5.

---

## What it does

- Log workouts with type, duration, and calories burned
- Track total calories burned and total workout time
- Set fitness goals and automatically check if they've been achieved

---

## How it works

The app is made up of four classes:

- **Workout** — represents a single workout session
- **Goal** — represents a fitness goal with a calorie target
- **FitnessLog** — stores all workouts and calculates totals
- **FitnessTracker** — the main service that connects everything together

---

## Clean Code Examples

### 1. Single Responsibility

Each class has one job. `FitnessLog` only manages the workout list. `FitnessTracker` only coordinates between classes. No class tries to do everything.

### 2. Meaningful Names

Method names clearly describe what they do — `getTotalCaloriesBurned()`, `markAchieved()`, `logWorkout()`. No abbreviations or vague names like `calc()` or `doThing()`.

### 3. Encapsulation

All fields are `private`. Data can only be accessed through getters and setters. This protects the data from being accidentally changed from outside the class.

---

## Test Cases

| Test                                    | Type     | What it checks                                  |
| --------------------------------------- | -------- | ----------------------------------------------- |
| `testLogWorkoutIncreasesCount`          | Positive | Logging a workout increases the count by 1      |
| `testTotalCaloriesBurned`               | Positive | Two workouts calories are added correctly       |
| `testTotalDurationMinutes`              | Positive | Two workouts durations are added correctly      |
| `testNoWorkoutsInitially`               | Negative | New tracker starts with 0 workouts              |
| `testNoCaloriesInitially`               | Negative | New tracker starts with 0 calories              |
| `testGoalAchievedWhenCaloriesMet`       | Positive | Goal is marked achieved when calories are met   |
| `testGoalNotAchievedWhenCaloriesNotMet` | Negative | Goal stays unachieved when calories are not met |
| `testMultipleWorkoutsCount`             | Positive | Three workouts are counted correctly            |
| `testWorkoutTypeIsStored`               | Positive | Workout type is stored and retrieved correctly  |
| `testGoalIsNotAchievedByDefault`        | Negative | New goal starts as not achieved                 |
| `testMultipleGoalsTracked`              | Positive | Multiple goals are stored correctly             |

---

## Dependencies

| Dependency            | Version | Purpose                      | Source                                                                                             |
| --------------------- | ------- | ---------------------------- | -------------------------------------------------------------------------------------------------- |
| JUnit Jupiter         | 5.10.1  | Unit testing framework       | [Maven Central](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter)                |
| Maven Surefire Plugin | 3.2.2   | Runs JUnit 5 tests via Maven | [Maven Central](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-surefire-plugin) |

---

## How to run the tests

Make sure you have Java 11 and Maven installed. Then clone the repo and run:

git clone https://github.com/BCoishous/Fitness-Tracker.git
cd Fitness-Tracker
mvn test

You should see `BUILD SUCCESS` with 11 tests passing.

## Project Structure

```
src/
├── main/java/com/fitnesstracker/
│   ├── model/
│   │   ├── Workout.java
│   │   ├── Goal.java
│   │   └── FitnessLog.java
│   └── service/
│       └── FitnessTracker.java
└── test/java/com/fitnesstracker/
    └── FitnessTrackerTest.java
```
