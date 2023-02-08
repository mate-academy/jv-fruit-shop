package core.basesyntax.service.impl;

import core.basesyntax.service.ReadCsv;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReadCsvImpl implements ReadCsv {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final int HEADER_LINE = 1;

    @Override
    public List<String> readCsvFile() {
        try {
            return Files.readAllLines(Path.of(INPUT_FILE_NAME))
            .stream()
            .skip(HEADER_LINE)
            .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + INPUT_FILE_NAME);
        }
    }
}
