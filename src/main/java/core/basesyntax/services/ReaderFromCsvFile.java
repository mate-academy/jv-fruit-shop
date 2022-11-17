package core.basesyntax.services;

import java.util.List;

public interface ReaderFromCsvFile {
    List<String> readFromFile(String filePath);
}
