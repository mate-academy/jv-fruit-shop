package services.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import services.FileWriterService;
import services.ReportGenerator;

public class FileWriterServiceImpl implements FileWriterService {
    private ReportGenerator reportGenerator;

    public FileWriterServiceImpl(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    @Override
    public void writeToFile(String filePath, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + filePath, e);
        }
    }
}
