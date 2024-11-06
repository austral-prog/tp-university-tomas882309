package com.university.CreatorsTests;

import com.university.ReaderAndWriter.CsvReader;
import com.university.SolutionsData.SolutionData2;
import com.university.creators.Creator2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class Creator2Test {


    @Test
    public void CreatorTest() {

        String imputcsv2 = "src/main/resources/input_2.csv";
        CsvReader csvReader2 = new CsvReader(imputcsv2);
        Creator2 creator2 = new Creator2(csvReader2.getData());

        assertEquals(30618, creator2.getEvaluations().size());

        SolutionData2 Solution2 = new SolutionData2(creator2.getEvaluations());
        Solution2.solution();

        assertEquals(30618, Solution2.getStringlines().size());



    }

}
