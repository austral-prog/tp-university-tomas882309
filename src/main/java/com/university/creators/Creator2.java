package com.university.creators;

import com.university.Evaluations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Creator2 {
    private static HashMap<String, Evaluation> evaluations;

    public Creator2(List<String[]> csvData){
        this.evaluations = new HashMap<>();
        GradesData(csvData);


    }

    public void GradesData (List<String[]> csvData){
        for (int i = 0; i < csvData.size(); i++){

            String studentName = csvData.get(i)[0];
            String subject = csvData.get(i)[1];
            String Evaluation_type = csvData.get(i)[2];
            String Evaluation_name = csvData.get(i)[3];
            String Exercise_name = csvData.get(i)[4];
            String Grade = csvData.get(i)[5];

            if (!evaluations.containsKey(subject + "," + Evaluation_name + "," + studentName + "," + Evaluation_type)) {

                if (Objects.equals(Evaluation_type, "WRITTEN_EXAM")) {
                    Evaluation evaluation = new WrittenExams(Evaluation_name);
                    evaluations.computeIfAbsent(subject + "," + Evaluation_name + "," + studentName + "," + Evaluation_type, k -> evaluation);
                    evaluation.addGrades(Double.parseDouble(Grade));

                } else if (Objects.equals(Evaluation_type, "PRACTICAL_WORK")) {
                    Evaluation evaluation = new PracticalWorks(Evaluation_name);
                    evaluations.computeIfAbsent(subject + "," + Evaluation_name + "," + studentName + "," + Evaluation_type, k -> evaluation);
                    evaluation.addGrades(Double.parseDouble(Grade));

                } else if (Objects.equals(Evaluation_type, "FINAL_PRACTICAL_WORK")) {
                    Evaluation evaluation = new FinalExams(Evaluation_name);
                    evaluations.computeIfAbsent(subject + "," + Evaluation_name + "," + studentName + "," + Evaluation_type, k -> evaluation);
                    evaluation.addGrades(Double.parseDouble(Grade));

                } else if (Objects.equals(Evaluation_type, "ORAL_EXAM")) {
                    Evaluation evaluation = new OralExams(Evaluation_name);
                    evaluations.computeIfAbsent(subject + "," + Evaluation_name + "," + studentName + "," + Evaluation_type, k -> evaluation);
                    evaluation.addGrades(Double.parseDouble(Grade));
                }
            } else {
                evaluations.get(subject + "," + Evaluation_name + "," + studentName + "," + Evaluation_type).addGrades(Double.parseDouble(Grade));
            }
        }
    }
    public HashMap<String, Evaluation> getEvaluations() {
        return evaluations;
    }
}
