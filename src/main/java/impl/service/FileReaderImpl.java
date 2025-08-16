package impl.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import service.FileReader;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        if (filePath == null) {
            throw new RuntimeException("File path cannot be null");
        }
        try {
            return Files.readAllLines(Paths.get(filePath)).stream()
                    .skip(1)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }
}
