package com.university.EvaluationsTests;

import com.university.Evaluations.WrittenExams;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WrittenExamsTest {

    @Test
    public void testFinalExams() {
        WrittenExams f = new WrittenExams("Written Exams");
        assertEquals("Written Exams", f.getName());
        f.addGrades(2.0);
        f.addGrades(4.0);
        f.addGrades(6.0);
        f.addGrades(2.0);
        f.addGrades(4.0);
        assertEquals(3.6,f.getFinalGrade());
    }
}
