package com.airtribe.lms;

import java.util.List;

import com.airtribe.lms.common.CourseType;
import com.airtribe.lms.common.Specialization;
import com.airtribe.lms.service.Lms;

public class App {
    public static void main(String[] args) {
        Lms lms = new Lms();

        lms.createCourse("C-JAVA-ON", "Java Bootcamp Online", CourseType.ONLINE, Specialization.JAVA);
        lms.createCourse("C-NODE-OF", "Node.js Bootcamp Offline", CourseType.OFFLINE, Specialization.NODE_JS);

        lms.createInstructor("I-100", "Alice Instructor");
        lms.createInstructor("I-101", "Bob Instructor");

        lms.createLearner("L-1", "Jill Java", Specialization.JAVA);
        lms.createLearner("L-2", "Jack Java", Specialization.JAVA);
        lms.createLearner("L-3", "Nina Node", Specialization.NODE_JS);

        lms.createCohort("H-01", "Java Cohort A", "C-JAVA-ON");
        lms.createCohort("H-02", "Node Cohort B", "C-NODE-OF");

        lms.assignInstructorToCohort("H-01", "I-100");
        lms.assignInstructorToCohort("H-02", "I-101");

        lms.enrollLearnerToCohort("H-01", "L-1");
        lms.enrollLearnerToCohort("H-01", "L-2");
        lms.enrollLearnerToCohort("H-02", "L-3");

        lms.addXpToLearner("L-1", 120);
        lms.addXpToLearner("L-2", 80);
        lms.addXpToLearner("L-3", 150);

        printSection("COURSES", lms.displayCourses());
        printSection("INSTRUCTORS", lms.displayInstructors());
        printSection("LEARNERS", lms.displayLearners());
        printSection("COHORTS", lms.displayCohorts());
    }

    private static void printSection(String title, List<String> lines) {
        System.out.println("==== " + title + " ====");
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println();
    }
}