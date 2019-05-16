package com.training.preassess.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    @NotNull
    private int userId;
    @NotNull
    private String name;
    @NotNull
    private int score;

    public int getCustomerId() {
        return customerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
