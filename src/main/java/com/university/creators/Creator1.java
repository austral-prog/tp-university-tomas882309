package com.university.creators;

import com.university.objects.Course;
import com.university.objects.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Creator1 {

    private Map<String, Student> students;
    private Map<String, Course> courses;

    public Creator1(List<String[]> csvData) {
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
        CreateStudentAndCourse(csvData);
    }

    public void CreateStudentAndCourse(List<String[]> csvData){
        for (int i = 0; i < csvData.size(); i++){

            String Classroom = csvData.get(i)[0];
            String subject = csvData.get(i)[1];
            String studentName = csvData.get(i)[2];
            String studentEmail = csvData.get(i)[3];
            String teacher = csvData.get(i)[4];

            if (!students.containsKey(studentName)){
                Student student = new Student(studentName, studentEmail);
                students.put(studentName, student);
                student.addCourse(subject);

            }
            else{
                students.get(studentName).addCourse(subject);

            }
            if (!courses.containsKey(subject)){
                Course course = new Course(subject);
                courses.put(subject, course);
                course.addClass(Classroom);
                course.addTeacher(teacher);
            }
            else{
                courses.get(subject).addClass(Classroom);
                courses.get(subject).addTeacher(teacher);
            }
        }

    }

    public List<Student> getStudents() {
        return new ArrayList<>(students.values());
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses.values());
    }
}
