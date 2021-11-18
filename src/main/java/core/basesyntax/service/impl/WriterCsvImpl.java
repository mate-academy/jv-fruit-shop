package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterCsvImpl implements Writer {
    @Override
    public void writeToFile(String report, String outputFilePath) {
        try {
            Files.write(Path.of(outputFilePath), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + outputFilePath, e);
        }
    }
}
