package sw_testing_project;

enum Grade{
    A_PLUS,    A,    A_MINUS,
    B_PLUS,    B,    B_MINUS,
    C_PLUS,    C,    C_MINUS,
    D_PLUS,    D,
    F,
}


public class StudentRecord {
    /*
    * Student record attributes
    * */
    public String name;
    public String number;
    public int activities_mark;
    public int practical_mark;
    public int midterm_mark;
    public int final_mark;

    // to be calculated based on student marks;
    Grade student_grade;
    float student_gpa;

    public int get_total_marks(){
        return (activities_mark + practical_mark + midterm_mark + final_mark);
    }

    /*
    * A function to calculate the student's grade based on the total mark
    * */
    public Grade get_grade(){
        Grade result=Grade.A_PLUS; // default value
        int total = get_total_marks();

        if(total< 60){
            result = Grade.F;
        }else if ((total >= 60) && (total<64)){
            result = Grade.D;
        }else if ((total >= 64) && (total<67)) {
            result = Grade.D_PLUS;
        }else if ((total >= 67) && (total<70)){
                result = Grade.C_MINUS;
        }else if ((total >= 70) && (total<73)){
            result = Grade.C;
        }else if ((total >= 73) && (total<76)){
            result = Grade.C_PLUS;
        }else if ((total >= 76) && (total<80)){
            result = Grade.B_MINUS;
        }else if ((total >= 80) && (total<84)){
            result = Grade.B;
        }else if ((total >= 84) && (total<89)){
            result = Grade.B_PLUS;
        }else if ((total >= 89) && (total<93)){
            result =Grade.A_MINUS;
        }else if ((total >= 93) && (total<97)){
            result = Grade.A;
        }else if ((total >= 97) && (total<=100)){
            result = Grade.A_PLUS;
        }

        return result;
    }

    /*
    * A static function to calculate the GPA based on the input grade
    * */
    public static float get_gpa(Grade grade){
        float result = switch (grade) {
            case F -> 0;
            case D -> 1;
            case D_PLUS -> 1.3f;
            case C_MINUS -> 1.7f;
            case C -> 2f;
            case C_PLUS -> 2.3f;
            case B_MINUS -> 2.7f;
            case B -> 3f;
            case B_PLUS -> 3.3f;
            case A_MINUS -> 3.7f;
            case A, A_PLUS -> 4f;
            default -> 4f;
        };

        return result;
    }
}
