package com.ambrose.myFitness.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uid;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true, unique = false)
    private LocalDate dateOfBirth;

    private int currWeight;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Workout> workouts = new ArrayList<>();

    // Getters and Setters

    public Long getId(){ return id;}

    public void setId(Long id) {this.id = id;}

    public String getUsername() {return username;}

    public void setUserName(String username) {this.username = username;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public LocalDate getDateOfBirth() {return dateOfBirth;}

    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public int getCurrWeight() {return currWeight;}

    public void setCurrWeight(int weight) {this.currWeight = weight;}

    public List<Workout> getWorkouts() {return workouts;}

    public void addWorkout(Workout workout) {
        workout.setUser(this);
        this.workouts.add(workout);
    }

    public void removeWorkout(Workout workout) {
        this.workouts.remove(workout);
        workout.setUser(null);
    }
}
