package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvWriterService implements WriterService {
    @Override
    public void writeReportToFile(String data, String name) {
        try {
            Files.write(Paths.get(name + ".csv"), data.getBytes());
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't write data to the file", e);
        }
    }
}
