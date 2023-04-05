import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;


public class testWriteToFile {

	String readFile(String path)
	{
		String line;
		String data="";

		FileReader fileReader;
		try {
			fileReader = new FileReader(path);
			BufferedReader buf_read = new BufferedReader(fileReader);
			line = buf_read.readLine();

			while(line != null) {
				data = data + line + "\n";
				line = buf_read.readLine();
			}
			// close stream/buffer
			buf_read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;

	}


	@Test
	public void testWriteToFile() {
		CourseRecord course_recorde = new CourseRecord();
		course_recorde.name = "Software Testing";
		course_recorde.code ="123";
		course_recorde.full_mark=100;
		course_recorde.students = new StudentRecord[0];
		String expected = "Subject Name: Software Testing      Max Mark: 100"+"\n"
				+ "Student name    Student number    GPA    Grade    "+"\n";

		FileManager.write_file(course_recorde, "testFile.txt");
		String data = readFile("testFile.txt");


		assertEquals(expected, data);
	}
	//Test that the function throws an exception when the filename is null:
	@Test(expected = NullPointerException.class)
	public void testWriteToFileNullFileName() throws IOException {
		CourseRecord course_recorde = new CourseRecord();
		course_recorde.name = "Software Testing";
		course_recorde.code ="123";
		course_recorde.full_mark=100;
		course_recorde.students = new StudentRecord[0];
		String fileName = null;
		FileManager.write_file(course_recorde, fileName);

	}
	//Test that the function throws an exception when the content is null:
	@Test(expected = NullPointerException.class)
	public void testWriteToFileNullContent() throws IOException {

		CourseRecord course_recorde = new CourseRecord();
		course_recorde.name = null;
		course_recorde.code =null;
		course_recorde.full_mark = (Integer) null;
		course_recorde.students = new StudentRecord[0];
		String fileName = "testFile1.txt";
		FileManager.write_file(course_recorde, fileName);
	}
	//Test that the function creates a new file if it doesn't exist:
	@Test
	public void testWriteToFileNewFile() throws IOException {

		CourseRecord course_recorde = new CourseRecord();
		course_recorde.name = "Software Testing";
		course_recorde.code ="123";
		course_recorde.full_mark=100;
		course_recorde.students = new StudentRecord[0];
		String fileName = "newFile.txt";
		FileManager.write_file(course_recorde,fileName );

		assertTrue(new File(fileName).exists());
	}
	//Test that the function overwrites the content of an existing file:
	@Test
	public void testWriteToFileOverwrite() throws IOException {

		//old values 
		CourseRecord course_recorde = new CourseRecord();
		course_recorde.name = "AI";
		course_recorde.code ="123";
		course_recorde.full_mark=100;
		course_recorde.students = new StudentRecord[0];
		FileManager.write_file(course_recorde, "testFile.txt");

		//new values to write
		CourseRecord course_recorde2 = new CourseRecord();
		course_recorde2.name = "Software Testing";
		course_recorde2.code ="123";
		course_recorde2.full_mark=100;
		course_recorde2.students = new StudentRecord[0];
		FileManager.write_file(course_recorde2, "testFile.txt");

		
		String expected = "Subject Name: Software Testing      Max Mark: 100"+"\n"
				+ "Student name    Student number    GPA    Grade    "+"\n";
		String data = readFile("testFile.txt");
		assertEquals(expected, data);


	}

}
