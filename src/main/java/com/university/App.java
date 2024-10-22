package com.university;

public class App {
    public static void main(String[] args) {
        String imputcsv = "C:/Users/User/PROGRAMACION/Programacion2/tp_university/tp-university-tomas882309/src/main/resources/input.csv";
        CsvReader csvReader = new CsvReader(imputcsv);
        Creator creator1 = new Creator(csvReader.getData());

        CsvWriter csvWriter = new CsvWriter();
        csvWriter.writeToFile(creator1.getStudents());

    }
}
