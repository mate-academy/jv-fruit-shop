package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvWriter implements Writer {
    @Override
    public void writeReportToFile(String report, String toFile) {
        try {
            Files.write(Path.of(toFile), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file" + toFile);
        }
    }
}
