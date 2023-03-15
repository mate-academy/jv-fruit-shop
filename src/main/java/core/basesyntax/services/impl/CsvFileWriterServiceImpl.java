package core.basesyntax.services.impl;

import core.basesyntax.services.CsvFileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writeToCsvFile(byte[] dataInBytes, Path filePath) {
        try {
            Files.write(filePath,dataInBytes);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report into file " + filePath, e);
        }
    }
}
