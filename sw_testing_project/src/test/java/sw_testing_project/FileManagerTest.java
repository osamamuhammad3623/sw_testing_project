package sw_testing_project;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileManagerTest {

    String valid_data = "English,ENG101,100\n" +
            "John Doe,12345678,8,9,18,50\n" +
            "Jane Smith,23456789,10,8,17,52\n" +
            "Bob Johnson,34567890,9,10,20,55\n" +
            "Alice Lee,45678901,7,6,16,45\n" +
            "Tom Brown,56789012,8,7,18,48\n" +
            "Sara Davis,67890123,10,9,19,58\n" +
            "David Wilson,78901234,9,8,17,53";

    CourseRecord valid_course_record = FileManager.parse_input(valid_data);


    @Test
    public void parse_input_test_course_name() {
        assertEquals(valid_course_record.name, "English");
    }

    @Test
    public void parse_input_test_course_code() {
        assertEquals(valid_course_record.code, "ENG101");
    }

    @Test
    public void parse_input_test_course_full_mark() {
        assertEquals(valid_course_record.full_mark, 100);
    }


    @Test
    public void parse_input_test_student_data() {

        // expected results coming from the sample input
        StudentRecord expected_students[] = new StudentRecord[3]; // hold students at indices 0, 3 & 6
        expected_students[0] = new StudentRecord("John Doe", "12345678", 8, 9, 18 ,50);
        expected_students[1] = new StudentRecord("Alice Lee", "45678901", 7, 6, 16 ,45);
        expected_students[2] = new StudentRecord("David Wilson", "78901234", 9, 8, 17 ,53);

        // actual results coming from the parse_input method
        StudentRecord[] actual_students = new StudentRecord[3];
        actual_students[0] = valid_course_record.students[0];
        actual_students[3] = valid_course_record.students[3];
        actual_students[6] = valid_course_record.students[6];

        assertEquals(expected_students, actual_students);
    }
}