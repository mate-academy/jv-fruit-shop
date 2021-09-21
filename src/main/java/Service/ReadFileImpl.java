package Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileImpl implements ReadFile {
    public static final String PATH_RESOURCE = "src/main/resources/";

    @Override
    public String readFile(String fileName) {
        String fileNamePath = PATH_RESOURCE + fileName;
        StringBuilder builder;
        try {
            File file = new File(fileNamePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + fileNamePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
        return builder.toString();
    }
}
