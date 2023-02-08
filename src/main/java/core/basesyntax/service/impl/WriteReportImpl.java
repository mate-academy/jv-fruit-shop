package core.basesyntax.service.impl;

import core.basesyntax.service.WriteReport;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReportImpl implements WriteReport {
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    @Override
    public void writeCsv(String report) {
        try (FileWriter writer = new FileWriter(REPORT_FILE_NAME, false)) {
            writer.write(report);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + REPORT_FILE_NAME);
        }
    }
}
