package sw_testing_project;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentRecordTest {

    @Test
    public void get_total_marks_with_valid_marks() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 8;
        temp.final_mark = 45;
        temp.activities_mark = 8;
        temp.midterm_mark = 15;

        assertEquals(temp.get_total_marks(), (8+8+15+45));
    }

    @Test
    public void get_total_marks_with_zeros() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 0;
        temp.final_mark = 0;
        temp.activities_mark = 0;
        temp.midterm_mark = 0;

        assertEquals(temp.get_total_marks(), 0);
    }

    @Test
    public void get_total_marks_with_full_marks() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 10;
        temp.final_mark = 60;
        temp.activities_mark = 10;
        temp.midterm_mark = 20;

        assertEquals(temp.get_total_marks(), 100);
    }

    /* a set of Equivalence Partitioning testcases */
    @Test
    public void get_grade_failed() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 0;
        temp.final_mark = 50;
        temp.activities_mark = 0;
        temp.midterm_mark = 5;

        assertEquals(temp.get_grade(), Grade.F);
    }

    @Test
    public void get_grade_D() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 0;
        temp.final_mark = 60;
        temp.activities_mark = 0;
        temp.midterm_mark = 2;

        assertEquals(temp.get_grade(), Grade.D);
    }

    @Test
    public void get_grade_D_plus() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 0;
        temp.final_mark = 60;
        temp.activities_mark = 0;
        temp.midterm_mark = 5;

        assertEquals(temp.get_grade(), Grade.D_PLUS);
    }

    @Test
    public void get_grade_C_minus() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 0;
        temp.final_mark = 60;
        temp.activities_mark = 0;
        temp.midterm_mark = 8;

        assertEquals(temp.get_grade(), Grade.C_MINUS);
    }

    @Test
    public void get_grade_C() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 10;
        temp.final_mark = 60;
        temp.activities_mark = 0;
        temp.midterm_mark = 2;

        assertEquals(temp.get_grade(), Grade.C);
    }

    @Test
    public void get_grade_C_plus() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 10;
        temp.final_mark = 60;
        temp.activities_mark = 0;
        temp.midterm_mark = 5;

        assertEquals(temp.get_grade(), Grade.C_PLUS);
    }

    @Test
    public void get_grade_B_minus() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 10;
        temp.final_mark = 60;
        temp.activities_mark = 0;
        temp.midterm_mark = 8;

        assertEquals(temp.get_grade(), Grade.B_MINUS);
    }

    @Test
    public void get_grade_B() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 10;
        temp.final_mark = 60;
        temp.activities_mark = 10;
        temp.midterm_mark = 2;

        assertEquals(temp.get_grade(), Grade.B);
    }

    @Test
    public void get_grade_B_plus() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 10;
        temp.final_mark = 60;
        temp.activities_mark = 10;
        temp.midterm_mark = 6;

        assertEquals(temp.get_grade(), Grade.B_PLUS);
    }

    @Test
    public void get_grade_A_minus() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 10;
        temp.final_mark = 60;
        temp.activities_mark = 10;
        temp.midterm_mark = 12;

        assertEquals(temp.get_grade(), Grade.A_MINUS);
    }

    @Test
    public void get_grade_A() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 10;
        temp.final_mark = 60;
        temp.activities_mark = 10;
        temp.midterm_mark = 15;

        assertEquals(temp.get_grade(), Grade.A);
    }

    @Test
    public void get_grade_A_plus() {
        StudentRecord temp = new StudentRecord();
        temp.practical_mark = 10;
        temp.final_mark = 60;
        temp.activities_mark = 10;
        temp.midterm_mark = 18;

        assertEquals(temp.get_grade(), Grade.A_PLUS);
    }

    @Test
    public void get_gpa_F() {
        assertEquals(StudentRecord.get_gpa(Grade.F), 0, 0);
    }

    @Test
    public void get_gpa_D() {
        assertEquals(StudentRecord.get_gpa(Grade.D), 1, 0);
    }

    @Test
    public void get_gpa_D_plus() {
        assertEquals(StudentRecord.get_gpa(Grade.D_PLUS), 1.3f, 0);
    }

    @Test
    public void get_gpa_C_minus() {
        assertEquals(StudentRecord.get_gpa(Grade.C_MINUS), 1.7f, 0);
    }

    @Test
    public void get_gpa_C() {
        assertEquals(StudentRecord.get_gpa(Grade.C), 2f, 0.0);
    }

    @Test
    public void get_gpa_C_plus() {
        assertEquals(StudentRecord.get_gpa(Grade.C_PLUS), 2.3f,0);
    }

    @Test
    public void get_gpa_B_minus() {
        assertEquals(StudentRecord.get_gpa(Grade.B_MINUS), 2.7f, 0);
    }

    @Test
    public void get_gpa_B() {
        assertEquals(StudentRecord.get_gpa(Grade.B), 3f, 0.0);
    }

    @Test
    public void get_gpa_B_plus() {
        assertEquals(StudentRecord.get_gpa(Grade.B_PLUS), 3.3f,0);
    }

    @Test
    public void get_gpa_A_minus() {
        assertEquals(StudentRecord.get_gpa(Grade.A_MINUS), 3.7f, 0);
    }

    @Test
    public void get_gpa_A() {
        assertEquals(StudentRecord.get_gpa(Grade.A), 4f, 0.0);
    }

    @Test
    public void get_gpa_A_plus() {
        assertEquals(StudentRecord.get_gpa(Grade.A_PLUS), 4f,0);
    }
}