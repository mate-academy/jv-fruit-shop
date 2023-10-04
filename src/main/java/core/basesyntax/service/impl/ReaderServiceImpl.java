package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderServiceImpl implements ReaderService {
    public List<String> readFromFile(String filePath) {
        List<String> inputData;
        try (Stream<String> lines = Files.lines(Path.of(filePath))) {
            inputData = lines.filter(line -> !line.isEmpty())
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + filePath, e);
        }
        return inputData;
    }
}
