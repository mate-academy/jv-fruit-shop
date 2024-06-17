package service.read;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReaderImpl implements FileReader {
    @Override
    public String[] readFile(String filePath) {
        String[] allLines = getAllLines(filePath);
        return allLines;
    }

    private String[] getAllLines(String filePath) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            return reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file" + filePath, e);
        }
    }
}
