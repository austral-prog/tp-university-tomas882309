package com.university.ReaderAndWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class CsvWriter<K> {

    public void WriteToFolder(String Header,List<K> printable, List<K> Value, String FileOutPut) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileOutPut))) {

            writer.write(Header);
            writer.newLine();

            for (int i = 0; i < printable.size(); i++) {

                writer.write(printable.get(i) + "," + Value.get(i));

                writer.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

