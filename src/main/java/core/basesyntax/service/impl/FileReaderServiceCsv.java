package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceCsv implements FileReaderService {
    private static final int INDEX_OF_FIRST_LINE = 1;

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> strings;
        try {
            strings = Files.readAllLines(Path.of(filePath)).stream()
                    .skip(INDEX_OF_FIRST_LINE)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file" + filePath, e);
        }
        return strings;
    }
}
