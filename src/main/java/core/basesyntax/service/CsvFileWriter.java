package core.basesyntax.service;

import java.nio.file.Path;

public interface CsvFileWriter {
    void writeDataToFile(Path path, String str);
}
