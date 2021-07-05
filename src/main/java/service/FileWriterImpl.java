package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public boolean writeToFile(String fileName, String report) {
        Path filePath = Paths.get(fileName);
        try {
            Files.writeString(filePath, report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + fileName, e);
        }
        return true;
    }
}
