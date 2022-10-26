package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeReport(String report, String path) {
        writeToFile(Path.of(path), report);
    }

    private void writeToFile(Path path, String data) {
        try {
            Files.writeString(path, data, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + path);
        }
    }
}
