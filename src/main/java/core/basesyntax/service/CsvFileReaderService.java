package core.basesyntax.service;

import java.util.List;

public interface CsvFileReaderService {
    List<String> readDataFromFileCsv(String filePath);
}
