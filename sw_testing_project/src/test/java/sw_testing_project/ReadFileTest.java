
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;


public class ReadFileTest {

	@Test
	public void testValidFilePath() throws FileNotFoundException {
		String expected = "English,ENG101,100"+"\n"+
				"John Doe,12345678,8,9,18,50"+"\n"+
				"Jane Smith,23456789,10,8,17,52"+"\n"+
				"Bob Johnson,34567890,9,10,20,55"+"\n"+
				"Alice Lee,45678901,7,6,16,45"+"\n"+
				"Tom Brown,56789012,8,7,18,48"+"\n"+
				"Sara Davis,67890123,10,9,19,58"+"\n"+
				"David Wilson,78901234,9,8,17,53"+"\n";
		String actual = FileManager.read_file("sample_input.txt");
		Assert.assertEquals(expected, actual);
	}


	@Test(expected = FileNotFoundException.class)
	public void testInvalidFilePath() throws FileNotFoundException {
		FileManager.read_file("nonexistent.txt");
	}

	@Test
	public void testEmptyFile() throws FileNotFoundException {
		String expected = "";
		String actual = FileManager.read_file("testEmptyFile.txt");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSingleLineFile() throws FileNotFoundException {
		String expected = "English,ENG101,100\n";
		String actual = FileManager.read_file("singleLineFile.txt");
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testInvalidFirstline() throws FileNotFoundException
	{
		String expected = "";
		String actual = FileManager.read_file("invalidFirstLine.txt");
		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void testUnexpectedLines() throws FileNotFoundException {
		String expected = "English,ENG101,100"+"\n"+
				"Jane Smith,23456789,10,8,17,52"+"\n"+
				"Bob Johnson,34567890,9,10,20,55"+"\n"+
				"Alice Lee,45678901,7,6,16,45"+"\n"+
				"Tom Brown,56789012,8,7,18,48"+"\n"+
				"Sara Davis,67890123,10,9,19,58"+"\n";
		String actual = FileManager.read_file("unexpectedLines.txt");
		Assert.assertEquals(expected, actual);
	}

	

}


