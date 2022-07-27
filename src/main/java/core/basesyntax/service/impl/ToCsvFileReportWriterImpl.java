package core.basesyntax.service.impl;

import core.basesyntax.service.ToCsvFileReportWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ToCsvFileReportWriterImpl implements ToCsvFileReportWriter {
    private static final String FILE_PATH = "src/main/resources/report.csv";

    @Override
    public void writeReport(String report, String header) {
        File reportCsv = new File(FILE_PATH);
        try {
            Files.write(reportCsv.toPath(), (header + report).getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file " + reportCsv.getName(), e);
        }
    }
}
