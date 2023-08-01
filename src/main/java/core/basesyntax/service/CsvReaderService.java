package core.basesyntax.service;

import java.util.List;

public interface CsvReaderService {
    List<String> readFromFile(String fromFile);
}
