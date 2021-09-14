package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String CANT_READ_FROM_FILE_EXCEPTION = "Can't read from file.";

    @Override
    public List<String> readRowsFromFile(String fileName) {
        List<String> rows;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            rows = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(CANT_READ_FROM_FILE_EXCEPTION);
        }
        return rows;
    }
}
