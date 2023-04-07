import static org.junit.Assert.*;

import org.junit.Test;


public class CourseRecordTest {

	@Test
	public void test_validCourseData()
    {
		CourseRecord temp = new CourseRecord();
    	temp.name = "Software Testing";
    	temp.code = "ENG101";
    	temp.full_mark =100;
         assertTrue(temp.is_valid());
    }
	@Test
	public void test_Invalid_nameWithSpaceAtFirst()
    {
		CourseRecord temp = new CourseRecord();
    	temp.name = " Software Testing";
    	temp.code = "ENG101";
    	temp.full_mark =100;
         assertFalse(temp.is_valid());
    }
	
	@Test
	public void test_Invalid_nameWithSpecialCahr()
    {
		CourseRecord temp = new CourseRecord();
    	temp.name = "Software Testing##";
    	temp.code = "ENG101";
    	temp.full_mark =100;
         assertFalse(temp.is_valid());
    }
	
	@Test
	public void test_Invalid_LongCodeLenght()
    {
		CourseRecord temp = new CourseRecord();
    	temp.name = "Software Testing";
    	temp.code = "ENG1011";
    	temp.full_mark =100;
         assertFalse(temp.is_valid());
    }
	
	@Test
	public void test_Invalid_ShortCodeLenght()
    {
		CourseRecord temp = new CourseRecord();
    	temp.name = "Software Testing";
    	temp.code = "ENG10";
    	temp.full_mark =100;
         assertFalse(temp.is_valid());
    }
	
	@Test
	public void test_Invalid_RigthLengthCode_NotEndedWith_S()
    {
		CourseRecord temp = new CourseRecord();
    	temp.name = "Software Testing";
    	temp.code = "ENG101m";
    	temp.full_mark =100;
         assertFalse(temp.is_valid());
    }
	
	@Test
	public void test_valid_RigthLengthCode_EndedWith_S()
    {
		CourseRecord temp = new CourseRecord();
    	temp.name = "Software Testing";
    	temp.code = "ENG101s";
    	temp.full_mark =100;
         assertTrue(temp.is_valid());
    }
	
	@Test
	public void test_Invalid_lessFullMark()
    {
		CourseRecord temp = new CourseRecord();
    	temp.name = "Software Testing";
    	temp.code = "ENG101";
    	temp.full_mark =99;
         assertFalse(temp.is_valid());
    }
	
	@Test
	public void test_Invalid_geaterFullMark()
    {
		CourseRecord temp = new CourseRecord();
    	temp.name = "Software Testing";
    	temp.code = "ENG101";
    	temp.full_mark =101;
         assertFalse(temp.is_valid());
    }

}
