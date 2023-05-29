package service.impl;

import db.Storage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import service.ReportService;
import service.WriterService;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeToFile(String filePath) {
        HashMap<String, Integer> finalReportMap = new HashMap<>(Storage.CURRENT_BALANCE_BY_FRUIT);
        ReportService reportService = new ReportServiceImpl();
        String newFilePath = filePath + File.separator + "Balance_Report.csv";
        File file = new File(newFilePath);
        String finalReport = reportService.getReportStringForWriting(finalReportMap);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create new file", e);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(finalReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file:" + file, e);
        }
    }
}
