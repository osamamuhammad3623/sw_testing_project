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
        for (int i=0; i< students.length; i++){
            // calculate the student grade
            g = students[i].get_grade();
            students[i].student_grade = g; // set the student grade
            students[i].student_gpa = students[i].get_gpa(g); // set the GPA based on the grade

        }
    }
}
