package core.basesyntax.services.impl;

import core.basesyntax.services.ReportWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    private static final String CANT_WRITE_DATA = "Can't write data to file: ";

    @Override
    public void write(String report, File reportFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(reportFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException(CANT_WRITE_DATA + reportFile, e);
        }
    }
}
