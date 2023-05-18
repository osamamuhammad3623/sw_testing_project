import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;


public class GradingReportGeneratorTestCases {

	@Test
	public void GenerateReportForValidFile () throws FileNotFoundException {
		
		int actualResult =  GradingReportGenerator.GenerateReport("sample_input.txt" , "out1.txt");
		assertEquals(1, actualResult);
	}
	
	
	@Test
	public void GenerateReportForEmptyFile () throws FileNotFoundException {
		
		int actualResult =  GradingReportGenerator.GenerateReport("emptyFile.txt" , "out1.txt");
		assertEquals(-1, actualResult);
	}
	
	@Test
	public void GenerateReportForFileWith_Invalid_First_Lines () throws FileNotFoundException {
		
		int actualResult =  GradingReportGenerator.GenerateReport("invalidFirstLine.txt" , "out1.txt");
		assertEquals(-1, actualResult);
	}
	
	@Test
	public void GenerateReportForFileWith_Invalid_inbetween_Lines () throws FileNotFoundException {
		
		int actualResult =  GradingReportGenerator.GenerateReport("unexpectedLines.txt" , "out1.txt");
		assertEquals(1, actualResult);
	}
}



