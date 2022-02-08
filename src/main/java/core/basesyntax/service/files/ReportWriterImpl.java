package core.basesyntax.service.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriterImpl implements ReportWriter {
    private static final String REPORT_HEADER = "fruitRecord,quantity";

    @Override
    public void writeReportToFile(String targetFile, List<String> report) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile, true))) {
            bw.write(REPORT_HEADER + System.lineSeparator());
            for (String record : report) {
                bw.write(record + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file, " + e);
        }
    }
}
