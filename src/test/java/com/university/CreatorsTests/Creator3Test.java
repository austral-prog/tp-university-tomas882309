package com.university.CreatorsTests;

import com.university.ReaderAndWriter.CsvReader;
import com.university.SolutionsData.SolutionData3;
import com.university.creators.Creator2;
import com.university.creators.Creator3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Creator3Test {

    @Test
    public void CreatorTest() {

        String imputcsv2 = "src/main/resources/input_2.csv";
        CsvReader csvReader2 = new CsvReader(imputcsv2);
        Creator2 creator2 = new Creator2(csvReader2.getData());

        String imputcsv3 = "src/main/resources/input_3.csv";
        CsvReader csvReader3 = new CsvReader(imputcsv3);
        Creator3 creator3 = new Creator3(csvReader3.getData(),creator2.getEvaluations());
        creator3.CalculateStatus(csvReader3.getData());

        assertEquals(creator3.getNotes().size(), creator3.getStatus().size());

        SolutionData3 Solution3 = new SolutionData3(creator3.getStatus());
        Solution3.Solution();

        assertEquals(creator3.getNotes().size(), Solution3.getStringLines().size());

    }

}
