package service.impl;

import service.ReadFromFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    private static final String FILE_PATH = "src/main/resources/inputInfo.csv";

    @Override
    public List<String> fileInfo() {
        List<String> fileInfo;
        try {
            fileInfo = Files.readAllLines(Path.of(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + FILE_PATH, e);
        }
        return fileInfo;
    }
}
