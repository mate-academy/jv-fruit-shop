package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> line;
        try {
            line = Files.lines(Paths.get(fileName)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read your file: " + fileName);
        }
        return line;
    }
}
