package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writeToFile(String data, String filePath) throws IOException {
        Files.write(Paths.get(filePath), data.getBytes());
    }
}
