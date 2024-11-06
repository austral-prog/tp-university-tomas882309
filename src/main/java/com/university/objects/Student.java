package com.university.objects;

import com.university.CLI.Entity;
import java.util.ArrayList;
import java.util.List;


public class Student implements Entity {
    private static int countStudents = 0;
    private int id;

    private String name;
    private String email;
    private List<String> courses = new ArrayList<String>();

    public Student(String name, String email) {

        this.name = name;
        this.email = email;
        this.id=countStudents;
        countStudents++;
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

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}

