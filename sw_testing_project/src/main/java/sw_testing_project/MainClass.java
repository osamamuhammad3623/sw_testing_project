import java.io.FileNotFoundException;



public class MainClass {

	public static void main(String[] args) throws FileNotFoundException{

		// read the input file
		String path = "sample_input.txt"; // relative path for sample input file
		String text = FileManager.read_file(path);

		if(!text.isEmpty())
		{
			// parse the input into a CourseRecord
			CourseRecord course_record = FileManager.parse_input(text);

			// process student records to calculate & set the grade & GPA of each student
			course_record.process_student_records();

			// write the CourseRecord - after calculating student grades & GPAs - into a file
			FileManager.write_file(course_record , "out.text");
		}

	}
}
