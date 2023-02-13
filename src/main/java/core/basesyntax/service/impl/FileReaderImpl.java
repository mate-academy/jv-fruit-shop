package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {
    private static final int HEADER_LINE = 1;

    @Override
    public List<String> read(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName))
            .stream()
            .skip(HEADER_LINE)
            .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
    }
}
