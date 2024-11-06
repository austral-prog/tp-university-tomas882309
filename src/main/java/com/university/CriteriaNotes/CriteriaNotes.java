package com.university.CriteriaNotes;

import java.util.List;

public abstract class CriteriaNotes {

    public abstract List<String> getStatus();

    abstract void calculateStatus(List<Double> Notes, Double criteriaValue);
}
