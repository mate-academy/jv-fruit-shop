package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriterServiceImpl implements ReportWriterService {
    @Override
    public void saveReport(List<String> reportList, String toFilePath) {
        File report = new File(toFilePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(report, true))) {
            for (String line : reportList) {
                bufferedWriter.write(line);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to file", e);
        }
    }
}
