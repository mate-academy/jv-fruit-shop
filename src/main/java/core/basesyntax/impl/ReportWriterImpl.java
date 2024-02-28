package core.basesyntax.impl;

import core.basesyntax.service.ReportWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeToFile(String report, String fileName) {
        try {
            Files.writeString(Path.of(fileName), report);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file " + fileName);
        }
    }
}
