package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.ReportWriterService;

public class ReportWriterServiceImpl implements ReportWriterService {

    public ReportWriterServiceImpl() {
    }

    @Override
    public void writeReportToFile(String report, String outputFilePath) throws IOException {
        try {
            Files.writeString(Path.of(outputFilePath), report);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Can`t write to file: " + outputFilePath, e);
        }
    }
}
