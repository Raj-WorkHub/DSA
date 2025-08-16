package com.airtribe.lms.model;

import com.airtribe.lms.common.CourseType;
import com.airtribe.lms.common.Specialization;
import com.airtribe.lms.core.Displayable;
import com.airtribe.lms.core.Identifiable;

public class Course implements Identifiable, Displayable {
    private final String id;
    private final String title;
    private final CourseType type;
    private final Specialization specialization;

    public Course(String id, String title, CourseType type, Specialization specialization) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.specialization = specialization;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public CourseType getType() {
        return type;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    @Override
    public String summary() {
        return "Course[" + id + "] " + title + " | " + type + " | " + specialization.displayName();
    }
}