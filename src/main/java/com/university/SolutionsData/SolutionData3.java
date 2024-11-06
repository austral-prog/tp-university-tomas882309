package com.university.SolutionsData;

import com.university.ReaderAndWriter.CsvWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SolutionData3 {

    private final HashMap<String, List<String>> Status;
    private List<String> StringLines = new ArrayList<>();
    private List<List<String>> Grade = new ArrayList<>();

    public SolutionData3(HashMap<String, List<String>> Status) {

        this.Status = Status;
    }
    public void Solution(){
        StringLines = new ArrayList<>(Status.keySet());
        Collections.sort(StringLines);

        for (String stringLine : StringLines) {
                Grade.add(Status.get(stringLine));
        }
    }

    public void sendSolution(){
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.WriteToFolder("Subject_Name,Evaluation_Type,Student_Name,Status" ,StringLines, Grade, "src/main/resources/solution3.csv");
    }

    public List<String> getStringLines() {
        return StringLines;
    }
}
