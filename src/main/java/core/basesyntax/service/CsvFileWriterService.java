package core.basesyntax.service;

import java.nio.file.Path;

public interface CsvFileWriterService {
    void writeToFile(String info, Path path);
}
