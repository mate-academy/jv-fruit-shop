package core.basesyntax.service;

import java.util.List;

public interface CsvFileReader {
    List<List<String>> readFile(String csvFilePath);
}
