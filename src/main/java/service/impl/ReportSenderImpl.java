package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.ReportSender;

public class ReportSenderImpl implements ReportSender {
    private final String filePath;

    public ReportSenderImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void sendReport(String report) {
        try (BufferedWriter writerReport = new BufferedWriter(new FileWriter(filePath))) {
            writerReport.write(report);
        } catch (IOException ioException) {
            throw new RuntimeException("Unable to write information to this file"
                    + filePath);
        }
    }
}
