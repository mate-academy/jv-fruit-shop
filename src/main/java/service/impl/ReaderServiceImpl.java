package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> read(String fromFile) {
        List<String> strings;
        try {
            strings = Files.readAllLines(Path.of(fromFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fromFile);
        }
        return strings;
    }
}
