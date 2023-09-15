package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class CsvReaderServiceImpl implements ReaderService {
    @Override
    public List<String> read(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.skip(1).toList();
        } catch (IOException e) {
            throw new RuntimeException("Some problems with file reading: " + fileName, e);
        }
    }
}
