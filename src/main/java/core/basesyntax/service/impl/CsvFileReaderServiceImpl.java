package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final String VALID_FIRST_LINE = "type,fruit,quantity";

    @Override
    public String read(String filePath) {
        checkFileNameForNull(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            checkFirstLine(reader.readLine());
            return reader
                    .lines()
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException("Something wrong with file's path " + filePath, e);
        }
    }

    private void checkFileNameForNull(String filePath) {
        if (filePath == null) {
            throw new RuntimeException("Input filePath is null!");
        }
    }

    private void checkFirstLine(String inputFirstLine) {
        if (!inputFirstLine.equals(VALID_FIRST_LINE)) {
            throw new RuntimeException("Your first line should be " + VALID_FIRST_LINE + ", but "
                    + "yours is " + inputFirstLine);
        }
    }
}
