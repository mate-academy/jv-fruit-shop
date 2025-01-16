package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class CsvFileReaderImpl implements FileReader {

    @Override
    public List<String> read(String filename) {
        Path path = Paths.get(filename);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.toList();
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + filename, e);
        }
    }
}
