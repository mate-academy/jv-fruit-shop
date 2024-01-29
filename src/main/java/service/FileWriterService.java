package service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterService {
    public void writeToFile(List<String> lines, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}
