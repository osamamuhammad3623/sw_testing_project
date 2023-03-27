package sw_testing_project;

public class CourseRecord {
    public String name;
    public String code;
    public int full_mark;

    public StudentRecord[] students; // array of students registered the course

    /*
    * A function to iterate on students & set their grades & GPAs
    * */
    public void process_student_records(){
        Grade g;
        for (StudentRecord student : students) {
            // calculate the student grade
            g = student.get_grade();
            student.student_grade = g; // set the student grade
            student.student_gpa = StudentRecord.get_gpa(g); // set the GPA based on the grade
        }
    }

    /*
    * A function to validate input the course-related data
    * */
    public boolean is_valid(){
        boolean result = false;

        // validate course name

        // validate course code
        return result;
    }
}
