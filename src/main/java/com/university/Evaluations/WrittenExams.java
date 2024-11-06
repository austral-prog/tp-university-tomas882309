package com.university.Evaluations;

import java.util.ArrayList;
import java.util.List;

public class WrittenExams implements Evaluation{
    private String name;
    private List<Double> grades;

    public WrittenExams(String name) {
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
        double sum = 0.0;
        for (double num : grades) {
            sum += num;
        }

        return sum / grades.size();
    }
}

