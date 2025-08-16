package com.airtribe.lms.model;

import com.airtribe.lms.common.Specialization;

public class Learner extends Person {
    private final Specialization specialization;
    private int experiencePoints;

    public Learner(String id, String name, Specialization specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void addExperiencePoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("XP cannot be negative");
        }
        this.experiencePoints += points;
    }

    @Override
    public String summary() {
        return super.summary() + " | " + specialization.displayName() + " | XP=" + experiencePoints;
    }
}