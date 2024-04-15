package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.ReportWriterService;

public class ReportWriterServiceImpl implements ReportWriterService {
    private final String pathToOutputFile = "src/main/resources/report.csv";

    @Override
    public void writeToFile(String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToOutputFile))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + pathToOutputFile, e);
        }
    }
}
