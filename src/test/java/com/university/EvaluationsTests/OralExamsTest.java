package com.university.EvaluationsTests;

import com.university.Evaluations.OralExams;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OralExamsTest {
    @Test
    public void testFinalExams() {
        OralExams f = new OralExams("OralExam");
        assertEquals("OralExam", f.getName());
        f.addGrades(2.0);
        assertEquals(2.0,f.getFinalGrade());
    }
}
