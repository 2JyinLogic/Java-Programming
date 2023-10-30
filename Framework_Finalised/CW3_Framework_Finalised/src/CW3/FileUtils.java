//2034355

package CW3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author andrew.abel
 */
public class FileUtils {
    public static List<Person> readFile(String filename) {
        List<Person> list = new ArrayList<>();
        try {
            Path path =  Paths.get(filename);
            BufferedReader reader = Files.newBufferedReader(path);
            String line = null;
            while ((line = reader.readLine()) != null) {
                if(!line.equals("")) {
                    System.out.println(line);
                    Person person = new Person(line);
                list.add(person);
                }
                
            }
            reader.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
}