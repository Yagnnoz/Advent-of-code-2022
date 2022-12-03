package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static String[] readFileToStringArray(String path) {

        List<String> listOfStrings = new ArrayList<>();

        try {
            BufferedReader bf = new BufferedReader((new FileReader(path)));
            String line = bf.readLine();
            while (line != null) {
                listOfStrings.add(line);
                line = bf.readLine();
            }

            bf.close();
            return  listOfStrings.toArray(new String[0]);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
