package com.university.Evaluations;

import java.util.ArrayList;
import java.util.List;

public class PracticalWorks implements Evaluation{
    private String name;
    private List<Double> grades;

    public PracticalWorks(String name) {
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
        return this.grades.getLast();
    }
}
