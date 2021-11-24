package shop.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import shop.service.ReportService;
import shop.service.Writer;

public class CsvWriterImpl implements Writer {
    private final ReportService reportService;

    public CsvWriterImpl() {
        reportService = new ReportServiceImpl();
    }

    @Override
    public boolean write(String outputFile) {
        List<String> report = reportService.makeReport();
        try {
            Files.write(Paths.get(outputFile), report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write in file");
        }
        return true;
    }
}
