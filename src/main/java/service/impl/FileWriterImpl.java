package service.impl;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl {
    public void write(String filePath, String content) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}
