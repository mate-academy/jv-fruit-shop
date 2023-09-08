package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import service.FileWriterService;
import service.ReportService;

public class FileWriterServiceImpl implements FileWriterService {
    private final ReportService reportService;

    public FileWriterServiceImpl() {
        reportService = new ReportServiceImpl();
    }

    @Override
    public boolean write(String outputFile) {
        List<String> report = reportService.createReport();
        try {
            Files.write(Paths.get(outputFile), report);
        } catch (IOException e) {
            throw new RuntimeException("can`t write in file");
        }
        return true;
    }
}
