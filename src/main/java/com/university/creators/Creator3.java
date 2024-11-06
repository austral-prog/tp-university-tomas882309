package com.university.creators;

import com.university.CriteriaNotes.AVERAGE_ABOVE_VALUE;
import com.university.CriteriaNotes.CriteriaNotes;
import com.university.CriteriaNotes.MAX_ABOVE_VALUE;
import com.university.CriteriaNotes.MIN_ABOVE_VALUE;
import com.university.Evaluations.Evaluation;

import java.util.*;

public class Creator3 {

    HashMap<String, Evaluation> evaluations;
    HashMap<String, List<Double>> Notes;
    HashMap<String, List<String>> Status;

    public Creator3(List<String[]> csvData, HashMap<String, Evaluation> evaluations){
        this.evaluations = evaluations;
        this.Notes = new HashMap<>();
        this.Status = new HashMap<>();
        GradesData(csvData);
    }

    public void GradesData (List<String[]> csvData){

        for (int i = 0; i < csvData.size(); i++){

            String subjectName = csvData.get(i)[0];
            String[] EvaluationNames = Arrays.copyOfRange(csvData.get(i),3,csvData.get(i).length);

            for (String key: evaluations.keySet()){
//                String Name = key.substring(0,key.indexOf(',')) + key.substring(key.indexOf(',',key.indexOf(',')+1), key.lastIndexOf(','));

                for (String evaluationName : EvaluationNames) {

                    if (key.contains(subjectName) && key.contains(evaluationName)) {
                        String newKey = key.substring(0,key.indexOf(',')) + "," + String.join(",", EvaluationNames) + key.substring(key.indexOf(',',key.indexOf(',')+1), key.lastIndexOf(','));;

                        if (!Notes.containsKey(newKey)){
                            Notes.put(newKey, new ArrayList<>());
                            Notes.get(newKey).add((this.evaluations.get(key)).getFinalGrade());

                        } else {
                            Notes.get(newKey).add((this.evaluations.get(key)).getFinalGrade());

                        }
                    }
                }
            }
        }
    }

    public void CalculateStatus(List<String[]> csvData){

        for (int i = 0; i < csvData.size(); i++) {

            String subjectName = csvData.get(i)[0];
            String CriteriaType = csvData.get(i)[1];
            String CriteriaValue = csvData.get(i)[2];
            String[] EvaluationNames = Arrays.copyOfRange(csvData.get(i), 3, csvData.get(i).length);

            for (String key: Notes.keySet()){
                if (key.contains(subjectName) && key.contains(String.join(",", EvaluationNames))) {

                    if (Objects.equals(CriteriaType, "AVERAGE_ABOVE_VALUE")){
                        CriteriaNotes CriteriaNote = new AVERAGE_ABOVE_VALUE(Notes.get(key), Double.parseDouble(CriteriaValue));
                        List<String> Final = CriteriaNote.getStatus();
                        Status.computeIfAbsent(key, k -> Final);

                    }else if (Objects.equals(CriteriaType, "MAX_ABOVE_VALUE")){
                        CriteriaNotes CriteriaNote = new MAX_ABOVE_VALUE(Notes.get(key), Double.parseDouble(CriteriaValue));
                        List<String> Final = CriteriaNote.getStatus();
                        Status.computeIfAbsent(key, k -> Final);

                    }else if (Objects.equals(CriteriaType, "MIN_ABOVE_VALUE")){
                        CriteriaNotes CriteriaNote = new MIN_ABOVE_VALUE(Notes.get(key), Double.parseDouble(CriteriaValue));
                        List<String> Final = CriteriaNote.getStatus();
                        Status.computeIfAbsent(key, k -> Final);

                    }
                }
            }
        }
    }
    public HashMap<String, List<String>> getStatus() {
        return Status;
    }
    public HashMap<String, List<Double>> getNotes(){
        return Notes;
    }
}
