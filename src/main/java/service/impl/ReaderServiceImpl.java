package service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file " + fileName);
        }
        return dataFromFile;
    }
}
