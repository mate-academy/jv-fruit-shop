package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> read(String filePath) {
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file " + filePath, e);
        }
    }
}
