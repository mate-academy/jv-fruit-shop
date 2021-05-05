package core.basesyntax.service.impls;

import core.basesyntax.service.ReportFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportFileWriterImpl implements ReportFileWriter {
    private static final String OUTPUT_HEADER = "fruit,quantity";

    @Override
    public void writeToFile(String outputFile, String report) {
        try (BufferedWriter reportWriter = new BufferedWriter(new FileWriter(outputFile))) {
            reportWriter.write(OUTPUT_HEADER + System.lineSeparator());
            reportWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + outputFile);
        }
    }
}
