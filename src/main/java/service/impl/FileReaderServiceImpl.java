package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> dateFromFile;
        try {
            dateFromFile = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("File can`t be read! Please, check filePath " + filePath, e);
        }
        return dateFromFile;
    }
}
