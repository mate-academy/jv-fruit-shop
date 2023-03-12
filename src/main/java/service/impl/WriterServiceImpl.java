package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.general.WriterService;

public class WriterServiceImpl implements WriterService {

    @Override
    public String writeToFile(String report, String reportPath, String defaultReportPath) {
        Path filePath;
        try {
            filePath = Path.of(reportPath);
        } catch (Exception e) {
            System.out.println("Unable to perform operations with destination " + reportPath
                    + ", switching to default destination");
            reportPath = defaultReportPath;
            filePath = Path.of(reportPath);
        }

        try {
            Files.deleteIfExists(filePath);
            Files.write(filePath, report.getBytes());
        } catch (IOException e) {
            System.out.println("Unable to perform operations with destination " + reportPath
                    + ", switching to default destination");
            try {
                reportPath = defaultReportPath;
                filePath = Path.of(reportPath);
                Files.deleteIfExists(filePath);
                Files.write(filePath, report.getBytes());
            } catch (IOException ex) {
                throw new RuntimeException("Unable to perform operations with " + reportPath, e);
            }
        }
        return reportPath;
    }
}
