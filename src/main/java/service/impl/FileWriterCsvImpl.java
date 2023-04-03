package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.FileWriterService;

public class FileWriterCsvImpl implements FileWriterService {
    @Override
    public void fileWriter(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            CreateReportImpl createReport = new CreateReportImpl();
            bufferedWriter.write(createReport.generateReport());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }
}
