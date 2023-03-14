package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.WriteReportService;

public class WriteReportServiceImpl implements WriteReportService {
    @Override
    public void writeReport(String report, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file " + filename, e);
        }
    }
}
