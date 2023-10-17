package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderService implements ReaderService {
    private final String fileName;

    public CsvFileReaderService(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> read() {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {

            return bufferedReader.lines().collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
    }
}
