package service.read.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.read.FileReader;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFromFile(String filePath, String filename) {
        try {
            return Files.readAllLines(Path.of(filePath + filename));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + filePath);
        }
    }
}
