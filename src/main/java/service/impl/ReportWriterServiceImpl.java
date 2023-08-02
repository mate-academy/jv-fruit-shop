package service.impl;

import service.*;

import java.io.*;

public class ReportWriterServiceImpl implements ReportWriterService {
    String outputFilePath;

    public ReportWriterServiceImpl(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    @Override
    public void writeReportToFile(String report, String outputFilePath) throws IOException {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.write(report);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Failed to write the report to: " + outputFilePath, e);
        }

    }
}
