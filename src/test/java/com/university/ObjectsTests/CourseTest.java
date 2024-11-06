package com.university.ObjectsTests;

import com.university.objects.Course;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CourseTest {

    @Test
    public void testCourse() {
        Course course = new Course("Programacion 2");
        course.addTeacher("Teacher");
        course.addClass("1");
        course.addClass("2");

        assertEquals("2", course.getClasses().get(1));
        assertEquals("Teacher", course.getTeachers().get(0));
        assertEquals("1", course.getClasses().get(0));
        assertEquals("Programacion 2", course.getSubject());
    }
}
