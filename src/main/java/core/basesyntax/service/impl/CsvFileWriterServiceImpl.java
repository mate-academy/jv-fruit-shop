package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writerToFile(Path pathToFile, String dataToAdd) {
        try {
            Files.writeString(pathToFile, dataToAdd);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + pathToFile.getFileName(), e);
        }
    }
}
