package service.impl;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl {
    public void write(String filePath, String content) {
        if (!AutoCloseable.class.isAssignableFrom(FileWriter.class)) {
            throw new IllegalStateException("FileWriter does not implement AutoClosable.");
        }
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + filePath, e);
        }
    }
}
