package core.basesyntax.service;

import java.nio.file.Path;

public interface CsvFileWriterService {
    void writerToFile(Path pathToFile, String dataToAdd);
}
