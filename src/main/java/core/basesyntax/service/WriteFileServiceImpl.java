package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileServiceImpl implements WriteFileService {
    @Override
    public void writeReportToFile(String report, String reportPath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reportPath))) {
            bufferedWriter.write(report);

        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + reportPath, e);
        }
    }
}
