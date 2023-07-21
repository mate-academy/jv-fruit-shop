package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {

    @Override
    public String read(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader
                    .lines()
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException("Something wrong with file's path " + fileName);
        }
    }
}
