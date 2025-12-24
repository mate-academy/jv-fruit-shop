package service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String content, String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + filePath, e);
        }
    }
}
