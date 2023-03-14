package com.mate.fruitshop.service.impl;

import com.mate.fruitshop.service.CsvWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CsvWriterImpl implements CsvWriter {
    public static final String DEFAULT_REPORT_NAME = "src/main/resources/report.csv";

    @Override
    public void writeToCsv(String report, String reportFileDir) {
        Path reportFile;
        try {
            reportFile = Paths.get(reportFileDir);
        } catch (Exception e) {
            reportFile = Paths.get(DEFAULT_REPORT_NAME);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(reportFile)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write report to:"
                    + reportFile, e);
        }
    }
}
