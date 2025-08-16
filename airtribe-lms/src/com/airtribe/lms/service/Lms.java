package com.airtribe.lms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.airtribe.lms.common.CourseType;
import com.airtribe.lms.common.Specialization;
import com.airtribe.lms.core.Displayable;
import com.airtribe.lms.model.Cohort;
import com.airtribe.lms.model.Course;
import com.airtribe.lms.model.Instructor;
import com.airtribe.lms.model.Learner;

public class Lms {
    private final Map<String, Course> idToCourse;
    private final Map<String, Cohort> idToCohort;
    private final Map<String, Instructor> idToInstructor;
    private final Map<String, Learner> idToLearner;

    public Lms() {
        this.idToCourse = new HashMap<>();
        this.idToCohort = new HashMap<>();
        this.idToInstructor = new HashMap<>();
        this.idToLearner = new HashMap<>();
    }

    public Course createCourse(String id, String title, CourseType type, Specialization specialization) {
        Course course = new Course(id, title, type, specialization);
        idToCourse.put(id, course);
        return course;
    }

    public Cohort createCohort(String id, String name, String courseId) {
        Course course = requireCourse(courseId);
        Cohort cohort = new Cohort(id, name, course);
        idToCohort.put(id, cohort);
        return cohort;
    }

    public Instructor createInstructor(String id, String name) {
        Instructor instructor = new Instructor(id, name);
        idToInstructor.put(id, instructor);
        return instructor;
    }

    public Learner createLearner(String id, String name, Specialization specialization) {
        Learner learner = new Learner(id, name, specialization);
        idToLearner.put(id, learner);
        return learner;
    }

    public void assignInstructorToCohort(String cohortId, String instructorId) {
        Cohort cohort = requireCohort(cohortId);
        Instructor instructor = requireInstructor(instructorId);
        cohort.assignInstructor(instructor);
    }

    public void enrollLearnerToCohort(String cohortId, String learnerId) {
        Cohort cohort = requireCohort(cohortId);
        Learner learner = requireLearner(learnerId);
        cohort.enrollLearner(learner);
    }

    public void addXpToLearner(String learnerId, int points) {
        requireLearner(learnerId).addExperiencePoints(points);
    }

    public List<String> displayCourses() {
        return summarize(new ArrayList<>(idToCourse.values()));
    }

    public List<String> displayCohorts() {
        return summarize(new ArrayList<>(idToCohort.values()));
    }

    public List<String> displayInstructors() {
        return summarize(new ArrayList<>(idToInstructor.values()));
    }

    public List<String> displayLearners() {
        return summarize(new ArrayList<>(idToLearner.values()));
    }

    private static List<String> summarize(List<?> items) {
        List<String> result = new ArrayList<>();
        for (Object obj : items) {
            if (obj instanceof Displayable) {
                result.add(((Displayable) obj).summary());
            } else {
                result.add(String.valueOf(obj));
            }
        }
        return result;
    }

    private Course requireCourse(String courseId) {
        Course course = idToCourse.get(courseId);
        if (course == null) {
            throw new IllegalArgumentException("Unknown course id: " + courseId);
        }
        return course;
    }

    private Cohort requireCohort(String cohortId) {
        Cohort cohort = idToCohort.get(cohortId);
        if (cohort == null) {
            throw new IllegalArgumentException("Unknown cohort id: " + cohortId);
        }
        return cohort;
    }

    private Instructor requireInstructor(String instructorId) {
        Instructor instructor = idToInstructor.get(instructorId);
        if (instructor == null) {
            throw new IllegalArgumentException("Unknown instructor id: " + instructorId);
        }
        return instructor;
    }

    private Learner requireLearner(String learnerId) {
        Learner learner = idToLearner.get(learnerId);
        if (learner == null) {
            throw new IllegalArgumentException("Unknown learner id: " + learnerId);
        }
        return learner;
    }
}