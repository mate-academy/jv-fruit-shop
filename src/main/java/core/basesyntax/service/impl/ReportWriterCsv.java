package core.basesyntax.service.impl;

import core.basesyntax.errors.ReportWriterError;
import core.basesyntax.service.ReportWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterCsv implements ReportWriter {
    @Override
    public void write(String[] report, String fileName) {
        try (
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            for (String line : report) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new ReportWriterError("Can't write report to file " + fileName, e);
        }
    }
}
