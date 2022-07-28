package core.basesyntax.service.impl;

import core.basesyntax.service.DailyReportWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DailyReportWriterImpl implements DailyReportWriter {

    @Override
    public void write(String report, String toFilePath) {
        try (FileWriter writer = new FileWriter(toFilePath)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to a file " + toFilePath, e);
        }
    }
}
