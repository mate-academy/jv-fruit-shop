package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.ReportWriterService;

public class ReportWriterServiceImpl implements ReportWriterService {

    @Override
    public void writeReport(List<String> reports, String toFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            for (int i = 0; i < reports.size() - 1; i++) {
                bufferedWriter.write(reports.get(i));
                bufferedWriter.write(System.lineSeparator());
            }
            bufferedWriter.write(reports.get(reports.size() - 1));
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
    }
}
