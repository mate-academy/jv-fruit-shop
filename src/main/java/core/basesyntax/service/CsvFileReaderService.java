package core.basesyntax.service;

import java.io.IOException;
import java.util.List;

public interface CsvFileReaderService {
    List<String> readFromFile(String filePath) throws IOException;
}
