package core.basesyntax.impl;

import core.basesyntax.service.WriteReportService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReportServiceImpl implements WriteReportService {
    @Override
    public void writeReport(String report, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write a file " + path, e);
        }
    }
}
