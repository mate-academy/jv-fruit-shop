package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> storageList = new ArrayList<>();
        try {
            storageList = Files.readAllLines(Path.of(fileName));
            return storageList;
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fileName, e);
        }
    }
}
