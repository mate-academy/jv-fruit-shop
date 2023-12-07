package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String RUNTIME_EXCEPTION_MESSAGE = "Can't read from file" +
            "Something went wrong";

    @Override
    public List<String> readFromFile(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.skip(1)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(RUNTIME_EXCEPTION_MESSAGE + filePath, e);
        }
    }
}
