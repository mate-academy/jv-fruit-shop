package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvFileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file ", e);
        }
    }
}
