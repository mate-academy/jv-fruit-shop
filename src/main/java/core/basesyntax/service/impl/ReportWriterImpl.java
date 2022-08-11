package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeToFile(String report, String pathname) {
        File file = new File(pathname);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
