package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReaderFileService;

public class ReaderFileServiceImpl implements ReaderFileService {

    @Override
    public List<String> readFromFile(String fileName) {
        List<String> fruitList;
        try {
            fruitList = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fruitList;
    }
}

