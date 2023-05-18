import java.io.FileNotFoundException;


public class GradingReportGenerator {

	public static  int GenerateReport(String inputFile_path, String outputFile_path ) throws FileNotFoundException
	{
		String text = FileManager.read_file(inputFile_path);

		if(!text.isEmpty())
		{
			// parse the input into a CourseRecord
			CourseRecord course_record = FileManager.parse_input(text);

			// process student records to calculate & set the grade & GPA of each student
			course_record.process_student_records();

			// write the CourseRecord - after calculating student grades & GPAs - into a file
			FileManager.write_file(course_record , outputFile_path);
			
			return 1; //means the report file is Generated successfully
		}
		return -1;//means Failed to generate the report file

	}
}
