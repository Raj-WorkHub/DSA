package com.airtribe.lms.common;

public enum Specialization {
    NODE_JS,
    JAVA;

    public String displayName() {
        return this == NODE_JS ? "Node.js" : "Java";
    }
}