package se.ecutbildning;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File source = new File("source/StreamAPI.pptx");
        File destination = new File("destination/StreamAPI copy.pptx");
        //copyWithFileReader(source,destination);
        //copyWithBufferedStream(source,destination);
        Path path = Paths.get("source/Random_text.txt");
        String[] awesomePeople = readFromTextFile(path);
        Arrays.stream(awesomePeople).forEach(s -> System.out.println("awesome " + s));

    }

    public static void copyWithFileReader(File src, File dest){
        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dest)){
            int b;
            while ((b = in.read()) != -1){
                out.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyWithBufferedStream(File src, File dest)  {
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest))){
            byte[] buffer = new byte[2048];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) >0){
                out.write(buffer, 0, bytesRead);
                out.flush();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static String[] readFromTextFile(Path path){
        try (BufferedReader reader= Files.newBufferedReader(path)){
            return reader.lines()
                    .toArray(count -> new String[count]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[0];
    }
}
