package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String path) {
        try {
            List<String> lines =  Files.readAllLines(Path.of(path));
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file: " + path, e);
        }
    }
}
