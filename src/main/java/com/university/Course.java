package com.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {

    private String subject;
    private List<String> teachers = new ArrayList<>();
    private List<String> Classes = new ArrayList<>();

    public Course(String subject) {
        this.subject = subject;
    }
    public String getSubject() {
        return this.subject;
    }
    public List<String> getTeachers() {
        return this.teachers;
    }
    public List<String> getClasses() {
        return this.Classes;
    }
    public void addTeacher(String teacher) {
        if (!this.teachers.contains(teacher)) {
            this.teachers.add(teacher);
        }
    }
    public void addClass(String classroom) {
        if (!this.Classes.contains(classroom)) {
            this.Classes.add(classroom);
        }
    }



}
