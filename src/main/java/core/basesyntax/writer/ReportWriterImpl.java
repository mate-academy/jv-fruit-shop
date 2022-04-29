package core.basesyntax.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {

    @Override
    public boolean writeReport(String report, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(report);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file in ReportWriterImpl!", e);
        }
    }
}
