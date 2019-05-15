package teamproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author 엄도윤
 */
public class UsingTextFile implements SaveLoadWay {

    @Override
    public void save(String str) {
        try(FileWriter fw = new FileWriter("myfile.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            out.println(str);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    @Override
    public String load(String str,int index1, int index2) {
        BufferedReader reader;
        try {
                reader = new BufferedReader(new FileReader(
                                "myfile.txt"));
                String line = reader.readLine();
                while (line != null) {
                        //System.out.println(line);
                        String spline = line;
                        String ID = spline.split("\\s")[index1];
                        int num = ID.compareTo(str);
                        if(num == 0){
                            String result = spline.split("\\s")[index2];
                            reader.close();
                            return result;
                        }
                        // read next line
                        line = reader.readLine();
                }
                reader.close();
        } catch (IOException e) {
                e.printStackTrace();
        }
        return "";
    }
    @Override
    public void modifyFile(String oldString, String newString)
    {
        File fileToBeModified = new File("myfile.txt");
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                reader.close(); 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
}
