package com.university.ObjectsTests;

import com.university.objects.Course;
import com.university.objects.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StudentTest {

    @Test
    public void testStudent() {
        Student student = new Student("Tomas", "StudentMail@gmail.com");
        Course course = new Course("Math");
        student.addCourse(course.getSubject());
        student.setId(1);

        assertEquals("Tomas", student.getName());
        assertEquals("StudentMail@gmail.com", student.getEmail());
        assertEquals(1, student.getCoursesCount());
        assertEquals("Math", student.getCourses().get(0));
        assertEquals(1, student.getId());

    }
}
