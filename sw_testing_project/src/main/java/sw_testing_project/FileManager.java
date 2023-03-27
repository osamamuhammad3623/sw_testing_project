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
    public CourseRecord parse_input(String data){
        CourseRecord result = new CourseRecord();

        return result;
    }

    /*
    * A function to write a CourseRecord into a file
    * */
    public static void write_file(CourseRecord course_record){

    }
}
