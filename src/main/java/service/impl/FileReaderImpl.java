package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FileReader;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String pathToFile) {
        try {
            return Files.readAllLines(Path.of(pathToFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + pathToFile, e);
        }
    }
}
