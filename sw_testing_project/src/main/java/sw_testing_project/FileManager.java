package sw_testing_project;

import java.io.*;

public class FileManager {

	/**
	 * A function to read a file & returns data as string
	 */
	public static String read_file(String absolute_file_path){
		String line;
		String data="";
		try
		{
			FileReader fileReader = new FileReader(absolute_file_path);
			BufferedReader buf_read = new BufferedReader(fileReader);

			// reading the file, line by line
			line = buf_read.readLine();
			while(line != null) {
				data = data + line + "\n";
				line = buf_read.readLine();
			}

			// close stream/buffer
			buf_read.close();
		}
		catch(IOException e)
		{
			System.out.println("Exception: " +e);
		}

		return data;
	}

	/*
	 * A function to parse the string - from file - and returns a CourseRecord containing the data.
	 * */
	public static CourseRecord parse_input(String data){

		String[] lines = data.split("\\r?\\n");
		String delims = "[,]+";
		String[] courseData = lines[0].split(delims);

		CourseRecord result = new CourseRecord();

		//retrieve the course data
		result.name = courseData[0];
		result.code = courseData[1];
		result.full_mark = Integer.parseInt(courseData[2]);

		// set number of students
		result.students = new StudentRecord[lines.length-1];
		for(int i = 1; i<lines.length ;i++)
		{
			String[] studentData = lines[i].split(delims);
			if(result.students != null)
			{
				result.students[i-1] = new StudentRecord();
				result.students[i-1].name = studentData[0];
				result.students[i-1].number = studentData[1];
				result.students[i-1].activities_mark = Integer.parseInt(studentData[2]);
				result.students[i-1].practical_mark = Integer.parseInt(studentData[3]);
				result.students[i-1].midterm_mark = Integer.parseInt(studentData[4]);
				result.students[i-1].final_mark = Integer.parseInt(studentData[5]);
			}
			

		}

		return result;
	}

	/*
	 * A function to write a CourseRecord into a file
	 * */
	public static void write_file(CourseRecord course_record){
		try {
			FileWriter myWriter = new FileWriter("filename.txt");
			myWriter.write("Subject Name: "+course_record.name+"      "+"Max Mark: "+course_record.full_mark+'\n');
			myWriter.write("Student name    "+"Student number    "+"GPA    "+"Grade    "+'\n');
			for (StudentRecord student : course_record.students)
			{
				myWriter.write(student.name+"  "+student.number+"  "+student.student_gpa+"  "+student.student_grade+'\n');
			}

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}


	}
}
