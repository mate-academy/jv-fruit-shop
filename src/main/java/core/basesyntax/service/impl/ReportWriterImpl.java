package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeReport(String report, String pathname) {
        File file = new File(pathname);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(report);
        } catch (IOException ex) {
            throw new RuntimeException("Can't write to file", ex);
        }
    }
}
