package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import service.interfaces.FileReaderService;

public class FilReaderImpl implements FileReaderService {

    @Override
    public List<String> readFromFile(String path) {
        List<String> fileContent = new ArrayList<>();
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException exception) {
            throw new RuntimeException("File does not exist!", exception);
        }
    }
}
