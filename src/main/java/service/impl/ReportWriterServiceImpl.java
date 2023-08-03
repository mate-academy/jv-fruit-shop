package service.impl;

import java.io.FileWriter;
import java.io.IOException;
import service.ReportWriterService;

public class ReportWriterServiceImpl implements ReportWriterService {
    private String outputFilePath;

    public ReportWriterServiceImpl(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    @Override
    public void writeReportToFile(String report) throws IOException {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.write(report);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Failed to write the report to: " + outputFilePath, e);
        }

    }
}
