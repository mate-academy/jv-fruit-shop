package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.CreateReportService;
import service.FileWriterService;

public class FileWriterCsvImpl implements FileWriterService {
    private CreateReportService createReport;

    public FileWriterCsvImpl(CreateReportService createReport) {
        this.createReport = createReport;
    }

    @Override
    public void writeFile(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(createReport.generateReport());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }
}
