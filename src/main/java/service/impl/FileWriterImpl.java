package service.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.createDirectories(path.getParent());
            try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
                writer.write(report);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while writing data to the file: "
                    + filePath, e);
        }
    }
}
