package sw_testing_project;

import java.io.*;

public class FileManager {

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

    public StudentRecord[] parse_input(String file_data){
        StudentRecord result[] = {};

        return result;
    }
    public static void write_file(){

    }
}
