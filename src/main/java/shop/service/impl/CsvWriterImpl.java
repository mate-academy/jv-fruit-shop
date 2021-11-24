package shop.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import shop.service.CsvWriter;
import shop.service.ReportService;

public class CsvWriterImpl implements CsvWriter {
    private final ReportService reportService;

    public CsvWriterImpl() {
        reportService = new ReportServiceImpl();
    }

    @Override
    public void write(String outputFile) {
        List<String> report = reportService.makeReport();
        try {
            Files.write(Paths.get(outputFile), report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write in file");
        }
    }
}
