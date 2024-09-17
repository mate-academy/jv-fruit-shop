package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String ERROR_MSG = "Can't read from file at: ";

    @Override
    public List<String> get(String path) {
        Path pathOfFile = Path.of(path);

        try (BufferedReader reader = Files.newBufferedReader(pathOfFile)) {
            return reader.lines()
                        .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MSG + pathOfFile, e);
        }
    }
}
