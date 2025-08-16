package com.airtribe.lms.model;

import com.airtribe.lms.core.Displayable;
import com.airtribe.lms.core.Identifiable;

public abstract class Person implements Identifiable, Displayable {
    private final String id;
    private final String name;

    protected Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String summary() {
        return getClass().getSimpleName() + "[" + id + "] " + name;
    }
}