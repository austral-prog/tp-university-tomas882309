package com.university.Evaluations;

import java.util.ArrayList;
import java.util.List;

public class FinalExams implements Evaluation{
    private String name;
    private List<Double> grades;

    public FinalExams(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    @Override
    public void addGrades(Double grade) {
        grades.add(grade);
    }

    @Override
    public String getName() {
        return this.name;

    }

    @Override
    public Double getFinalGrade() {
        Double finalGrade = 0.0;
        for (Double grade: grades){
            finalGrade += grade;
        }
        return finalGrade;
    }
}
