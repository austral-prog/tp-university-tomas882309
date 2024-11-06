package com.university.EvaluationsTests;
import com.university.Evaluations.FinalExams;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinalExamsTest {

    @Test
    public void testFinalExams() {
        FinalExams f = new FinalExams("FinalExam");
        assertEquals("FinalExam", f.getName());
        f.addGrades(2.0);
        f.addGrades(4.0);
        f.addGrades(6.0);
        f.addGrades(2.0);
        f.addGrades(4.0);
        assertEquals(18.0,f.getFinalGrade());
    }
}
