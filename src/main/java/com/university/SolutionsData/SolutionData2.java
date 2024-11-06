package com.university.SolutionsData;

import com.university.Evaluations.Evaluation;
import com.university.ReaderAndWriter.CsvWriter;
import com.university.objects.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SolutionData2 {

    private final HashMap<String, Evaluation> evaluations;
    private List<String> StringLines = new ArrayList<>();
    private List<Double> Grade = new ArrayList<>();

    public SolutionData2(HashMap<String, Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public void solution(){
        List<String> evaluationsListComplete =new ArrayList<>(evaluations.keySet());
        List<String> evaluationsList =new ArrayList<>(evaluations.keySet());

        for (int i = 0; i < evaluationsList.size(); i++) {
            String phrase = evaluationsList.get(i);
            String[] parts = phrase.split(",");

            if (parts.length > 3) {
                String newPhrase = String.join(",", parts[0], parts[1], parts[2]);
                evaluationsList.set(i, newPhrase);
            }
        }

        Collections.sort(evaluationsList);
        Collections.sort(evaluationsListComplete);

        int i = 0;
        for (String Data : evaluationsListComplete) {
            i++;
            Grade.addLast(evaluations.get(Data).getFinalGrade());
        }

        int j = 0;
        for (String Data : evaluationsList) {
            j++;
            StringLines.addLast(Data);
        }
    }

    public void sendSolution(){
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.WriteToFolder("Subject_Name,Evaluation_Name,Student_Name,Grade" ,StringLines, Grade, "src/main/resources/solution2.csv");
    }

    public List<String> getStringlines() {
        return StringLines;
    }
}


