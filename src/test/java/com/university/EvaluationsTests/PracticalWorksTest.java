package com.university.EvaluationsTests;

import com.university.Evaluations.PracticalWorks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracticalWorksTest {

    @Test
    public void testFinalExams() {
        PracticalWorks f = new PracticalWorks("PracticalWork");
        assertEquals("PracticalWork", f.getName());
        f.addGrades(2.0);
        f.addGrades(4.0);
        f.addGrades(6.0);
        f.addGrades(2.0);
        f.addGrades(4.0);
        assertEquals(4.0,f.getFinalGrade());
    }
}
