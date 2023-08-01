package core.basesyntax.service.implemantation;

import core.basesyntax.service.ReportWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeReport(String report, String fileNameToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameToWrite))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + fileNameToWrite, e);
        }
    }
}
