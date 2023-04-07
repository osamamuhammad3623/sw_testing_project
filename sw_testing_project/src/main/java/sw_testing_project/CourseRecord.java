

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

            if (student.is_valid()){
                // calculate the student grade
               g =   student.get_grade();
                student.student_gpa = StudentRecord.get_gpa(g); // set the GPA based on the grade
            }else{
                // error handling
            }
        }
    }

    /*
    * A function to validate input the course-related data
    * */
    public boolean is_valid(){
        boolean result = true;

        // validate course name
        // check that first char is NOT space
        if (Character.isSpaceChar(name.charAt(0))){
            result = false;
        }
        // check that every char is alpha
        for (int i=0; i< name.length(); i++){
            if (!Character.isLetter(name.charAt(i))){
                result = false;
                break;
            }
        }

        // validate course code
        if ((code.length() == 6) || (code.length() == 7)){
            // check that first 3 chars are alpha
            boolean first_3_alpha = Character.isLetter(code.charAt(0))
                    && Character.isLetter(code.charAt(1))
                    && Character.isLetter(code.charAt(2));

            // check that char 3-5 are numeric
            boolean three_char_numeric = Character.isDigit(code.charAt(3))
                    && Character.isDigit(code.charAt(4))
                    && Character.isDigit(code.charAt(5));

            if (first_3_alpha && three_char_numeric){
                // check if code is 7 chars, the 7th should be 's'
                if (!((code.length() == 7) && (code.charAt(6) == 's'))){
                    result = false;
                }
            }else{
                result = false;
            }

        }else{
            result = false;
        }

        // validate course full mark
        if(full_mark != 100){
            result = false;
        }
        return result;
    }
}
