package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileServiceImpl implements FileService {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + filePath, e);
        }
        return lines;
    }

    @Override
    public void writeToFile(String report, String filePath) {
        if (!Files.exists(Path.of(filePath))) {
            try {
                Files.createFile(Path.of(filePath));
            } catch (IOException e) {
                System.err.println("Failed to create new file: " + e.getMessage());
            }
        }
        try {
            Files.writeString(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + filePath, e);
        }
    }
}
