package com.university.CriteriaNotes;

import java.util.ArrayList;
import java.util.List;

public class AVERAGE_ABOVE_VALUE extends CriteriaNotes{
    private List<String> Status;

    public AVERAGE_ABOVE_VALUE(List<Double> Notes, Double criteriaValue) {
        this.Status = new ArrayList<>();
        calculateStatus(Notes, criteriaValue);
    }

    @Override
    void calculateStatus(List<Double> Notes, Double criteriaValue) {
        int sum = 0;
        for (Double note : Notes) {
            sum += note;
        }
        if (sum > criteriaValue) {
            Status.add("Approved");
        } else{
            Status.add("Failed");
        }

    }

    @Override
    public List<String> getStatus() {
        return Status;
    }
}
