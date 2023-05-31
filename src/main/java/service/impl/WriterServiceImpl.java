package service.impl;

import db.Storage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import service.ReportService;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String SEPARATOR = File.separator;

    @Override
    public void writeToFile(String filePath) {
        HashMap<String, Integer> finalReportMap = new HashMap<>(Storage.CURRENT_BALANCE_BY_FRUIT);
        ReportService reportService = new ReportServiceImpl();
        String newFilePath = filePath + SEPARATOR + "Balance_Report.csv";
        String finalReport = reportService.getReportStringForWriting(finalReportMap);
        try {
            Files.writeString(Path.of(newFilePath), finalReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file:" + filePath, e);
        }
    }
}
