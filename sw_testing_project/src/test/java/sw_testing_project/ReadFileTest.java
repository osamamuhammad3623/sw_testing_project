import org.junit.Assert;
import org.junit.Test;

import sw_testing_project.FileManager;


public class ReadFileTest {

	@Test
	public void testValidFilePath() {
		String expected = "This is a test file.\nIt contains some sample text.\n";
		String actual = FileManager.read_file("file.txt");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testInvalidFilePath() {
		String expected = "";
		String actual = FileManager.read_file("nonexistent.txt");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEmptyFile() {
		String expected = "";
		String actual = FileManager.read_file("testEmptyFile.txt");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSingleLineFile() {
		String expected = "This is a single line of text.\n";
		String actual = FileManager.read_file("singleLineFile.txt");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testMultipleLinesFile() {
		String expected = "This is line 1.\nThis is line 2.\nThis is line 3.\n";
		String actual = FileManager.read_file("multipleLinesFile.txt");
		Assert.assertEquals(expected, actual);
	}

}


