package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidValueExeption;
import core.basesyntax.service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceImpl implements CsvFileReaderService {
    private static final int FIRST_LINE = 1;
    private static final String REGEX = "^[bpsr],\\w+,[0-9]+$";

    @Override
    public List<String> readFile(String fileSource) {
        Path filePath = Paths.get(fileSource);
        if (!Files.exists(filePath)) {
            throw new RuntimeException("File not found: " + fileSource);
        }
        try {
            return Files.lines(filePath)
                    .skip(FIRST_LINE)
                    .peek(this::checkData)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file: " + fileSource, e);
        }
    }

    private void checkData(String line) {
        if (!line.matches(REGEX)) {
            throw new InvalidValueExeption("Data is in an incorrect format");
        }
    }
}
