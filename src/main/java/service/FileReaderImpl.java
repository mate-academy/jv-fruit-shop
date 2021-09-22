package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReaderImpl implements FileReader {
    public static final String PATH_RESOURCE = "src/main/resources/";

    @Override
    public String read(String filePath) {
        StringBuilder builder;
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + filePath, e);
        }
        return builder.toString();
    }
}
