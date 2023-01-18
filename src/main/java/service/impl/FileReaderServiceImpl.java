package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {
    private List<String> dataFileReader = new ArrayList<>();

    @Override
    public List<String> readDataFromFile(String pathFile) {
        try {
            dataFileReader = Files.readAllLines(Path.of(pathFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file by path: " + pathFile, e);
        }
        return dataFileReader;
    }
}
