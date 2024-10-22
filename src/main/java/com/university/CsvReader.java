package com.university;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private List<String[]> data;


    public CsvReader(String filePath) {
        data = new ArrayList<>();
        readCsv(filePath);
    }

    private void readCsv(String filePath) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                data.add(columns);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<String[]> getData() {
        return data;
    }
}
