package com.university.objects;

import java.util.ArrayList;
import java.util.List;

public class Course{
    private static int countCourses = 0;
    private int id;
    private String subject;
    private List<String> teachers = new ArrayList<>();
    private List<String> Classes = new ArrayList<>();

    public Course(String subject) {
        this.subject = subject;
        this.id=countCourses;
        countCourses++;

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
