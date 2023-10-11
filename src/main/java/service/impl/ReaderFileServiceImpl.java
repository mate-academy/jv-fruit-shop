package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReaderFileService;

public class ReaderFileServiceImpl implements ReaderFileService {

    @Override
    public List<String> readFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t find file by path" + fileName, e);
        }
    }
}

