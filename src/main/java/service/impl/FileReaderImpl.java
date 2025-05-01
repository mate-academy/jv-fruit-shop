package service.impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import service.FileReader;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (Exception e) {
            throw new RuntimeException("Can`t read file: " + filePath, e);
        }
    }
}
