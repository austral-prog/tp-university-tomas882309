package com.university.SolutionsData;

import com.university.ReaderAndWriter.CsvWriter;
import com.university.objects.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SolutionData1 {
    private List<Student> students;
    private List<String> StringLines = new ArrayList<>();
    private List<Integer> CountOfCourses = new ArrayList<>();


    public SolutionData1(List<Student> students) {

        this.students = students;
    }

    public void Solution() {

        Collections.sort(students, Comparator.comparing(Student::getName));

        int i = 0;
        for (Student student : students) {
            i++;

            StringLines.addLast(student.getName());
            CountOfCourses.add(student.getCoursesCount());
        }
    }

    public void sendSolution() {
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.WriteToFolder("Student_Name,Course_Count" ,StringLines, CountOfCourses, "src/main/resources/solution1.csv");
    }

    public List<String> getStringLines() {
        return StringLines;
    }

    public List<Integer> getCountOfCourses() {
        return CountOfCourses;
    }
}



