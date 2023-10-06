package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReaderFileService;

public class ReaderFileServiceImpl implements ReaderFileService {
    private static final String FILE_NAME_INPUT = "input.csv";

    @Override
    public List<String> readFromFile() {
        List<String> fruitList;
        try {
            fruitList = Files.readAllLines(Path.of(FILE_NAME_INPUT));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fruitList;
    }
}

