package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterImpl implements CsvFileWriter {
    private final String filePath;

    public CsvFileWriterImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String csvFormattedReport) {
        try {
            Files.writeString(Path.of(filePath), csvFormattedReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + filePath + '\'', e);
        }
    }
}
