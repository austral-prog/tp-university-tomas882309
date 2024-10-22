package com.university;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class CsvWriter {
    private String outputCSV = "src/main/resources/solution.csv";
    public void writeToFile(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputCSV))) {

            Collections.sort(students, Comparator.comparing(Student::getName));


            writer.write("Student_Name,Course_Count");
            writer.newLine();

            int i = 0;
            for (Student student : students) {
                i++;

                writer.write(student.getName() + "," + student.getCoursesCount());

                if (i < students.size()) {
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
