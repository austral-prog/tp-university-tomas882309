package com.university.CreatorsTests;

import com.university.ReaderAndWriter.CsvReader;
import com.university.SolutionsData.SolutionData1;
import com.university.creators.Creator1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Creator1Test {

    @Test
    public void CreatorTest() {
        String imputcsv = "src/main/resources/input.csv";
        CsvReader csvReader = new CsvReader(imputcsv);
        Creator1 creator1 = new Creator1(csvReader.getData());

        assertEquals(400,creator1.getStudents().size());

        SolutionData1 Solution1 = new SolutionData1(creator1.getStudents());
        Solution1.Solution();

        assertEquals(400,Solution1.getStringLines().size());

        assertEquals(20,creator1.getCourses().size());

        assertEquals(400, Solution1.getCountOfCourses().size());

    }

}



