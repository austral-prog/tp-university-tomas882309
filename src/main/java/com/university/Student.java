package com.university;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {

    private String name;
    private String email;
    private List<String> courses = new ArrayList<String>();

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public List<String> getCourses() {
        return this.courses;
    }
    public int getCoursesCount() {
        return this.courses.size();
    }
    public void addCourse(String subject) {
        if (!this.courses.contains(subject)) {
            this.courses.add(subject);
        }
    }

    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}

