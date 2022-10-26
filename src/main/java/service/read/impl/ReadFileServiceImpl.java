package service.read.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import service.read.ReadFileService;

public class ReadFileServiceImpl implements ReadFileService {
    private static final String CANT_READ_MESSAGE = "Can't read from file: ";

    @Override
    public List<String> readFromFile(String filePath) {
        File file = new File(filePath);
        try {
            List<String> transactions = Files.readAllLines(file.toPath());
            return transactions;
        } catch (IOException e) {
            throw new RuntimeException(CANT_READ_MESSAGE + file);
        }
    }
}
