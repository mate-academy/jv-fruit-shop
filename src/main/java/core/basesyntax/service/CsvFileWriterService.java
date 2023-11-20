package core.basesyntax.service;

import java.util.List;

public interface CsvFileWriterService {
    void writeToNewCsvFile(String fileName, List<String> dataToWrite);
}
