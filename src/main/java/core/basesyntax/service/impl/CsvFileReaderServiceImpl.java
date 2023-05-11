package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final String HEADER = "type,fruit,quantity";
    private static final int HEADER_INDEX = 0;

    @Override
    public List<String> readDataFromFile(String fileName) {
        try {
            return Files.lines(Path.of(fileName))
                    .filter(line -> !line.isEmpty())
                    .skip(HEADER_INDEX)
                    .filter(line -> !HEADER.equals(line))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Reading is failed " + fileName);
        }
    }
}
