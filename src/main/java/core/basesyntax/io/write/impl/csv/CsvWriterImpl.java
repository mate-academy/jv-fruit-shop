package core.basesyntax.io.write.impl.csv;

import core.basesyntax.io.write.ReportWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterImpl implements ReportWriter {
    @Override
    public void write(String report, String reportPath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reportPath))) {
            bufferedWriter.write(reportPath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to a file");
        }
    }
}
