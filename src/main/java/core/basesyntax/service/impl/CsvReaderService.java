package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvReaderService implements ReaderService {
    @Override
    public List<String> read(String filePath) {
        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.skip(1).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + filePath, e);
        }
    }
}
