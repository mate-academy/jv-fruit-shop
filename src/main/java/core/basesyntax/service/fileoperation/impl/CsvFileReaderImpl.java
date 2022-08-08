package core.basesyntax.service.fileoperation.impl;

import core.basesyntax.service.fileoperation.CsvFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderImpl implements CsvFileReader {

    @Override
    public List<String> inputFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't find this fileoperation " + filePath, e);
        }
    }
}
