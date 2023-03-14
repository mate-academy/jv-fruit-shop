package core.basesyntax.services;

import java.nio.file.Path;

public interface CsvFileWriterService {
    void writeToCsvFile(byte[] dataInBytes, Path filePath);
}
