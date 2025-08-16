package com.airtribe.lms.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.airtribe.lms.common.Specialization;
import com.airtribe.lms.core.Displayable;
import com.airtribe.lms.core.Identifiable;

public class Cohort implements Identifiable, Displayable {
    private final String id;
    private final String name;
    private final Course course;
    private Instructor instructor;
    private final List<Learner> learners;

    public Cohort(String id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = Objects.requireNonNull(course, "course");
        this.learners = new ArrayList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void assignInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void enrollLearner(Learner learner) {
        if (learner.getSpecialization() != course.getSpecialization()) {
            throw new IllegalArgumentException("Learner specialization must match course specialization");
        }
        learners.add(learner);
    }

    public List<Learner> getLearners() {
        return Collections.unmodifiableList(learners);
    }

    public double averageXp() {
        if (learners.isEmpty()) {
            return 0.0;
        }
        long total = 0L;
        for (Learner learner : learners) {
            total += learner.getExperiencePoints();
        }
        return total / (double) learners.size();
    }

    @Override
    public String summary() {
        String instructorName = instructor == null ? "Unassigned" : instructor.getName();
        return "Cohort[" + id + "] " + name + " | Course=" + course.getTitle() + " | Instructor=" + instructorName + " | Learners=" + learners.size();
    }
}