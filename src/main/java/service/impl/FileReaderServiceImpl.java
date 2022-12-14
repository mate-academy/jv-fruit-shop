package service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file: " + fileName, e);
        }
    }
}
