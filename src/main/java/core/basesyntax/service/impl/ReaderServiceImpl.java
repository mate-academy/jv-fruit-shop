package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReaderServiceImpl implements ReaderService {
    public List<String> readFromFile(String filePath) {
        List<String> inputData = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Path.of(filePath))) {
            lines.forEach(line -> {
                if (!line.isEmpty()) {
                    inputData.add(line);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputData;
    }
}
