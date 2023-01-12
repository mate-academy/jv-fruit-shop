package core.basesyntax.service;

import java.io.FileNotFoundException;
import java.util.List;

public interface CsvFileReaderService {
    String readFromFile(String filePath);
}
