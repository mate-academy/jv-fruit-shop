package core.basesyntax.service;

import java.io.IOException;

public interface CsvFileWriterService {
    void writeToFile(String report) throws IOException;
}
