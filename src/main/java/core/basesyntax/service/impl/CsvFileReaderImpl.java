package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public List<String> readCsvFileToStringList(String filePath) {
        List<String> stringListFromCsvFile;
        try {
            stringListFromCsvFile = Files.readAllLines(Path.of(filePath));
            stringListFromCsvFile.remove(0);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file \"" + filePath + "\"", e);
        }
        return stringListFromCsvFile;
    }
}
