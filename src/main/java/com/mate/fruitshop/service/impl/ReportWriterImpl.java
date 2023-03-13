package com.mate.fruitshop.service.impl;

import com.mate.fruitshop.service.ReportWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReportWriterImpl implements ReportWriter {
    public static final String DEFAULT_REPORT_DIR = "src/main/resources/report.csv";

    @Override
    public boolean writeReportToFile(String report, String reportFileDir) {
        Path reportFile;
        try {
            reportFile = Paths.get(reportFileDir);
        } catch (Exception e) {
            reportFile = Paths.get(DEFAULT_REPORT_DIR);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(reportFile)) {
            writer.write(report);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Unable to write report to:"
                    + reportFile, e);
        }
    }
}
