package service.impl;

import data.base.Storage;
import service.ReportGeneratorService;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    public String createReport() {
        String header = "fruit,quantity";
        String splitter = ",";
        StringBuilder reportBuilder = new StringBuilder();

        reportBuilder.append(header).append(System.lineSeparator());
        Storage.STORAGE.forEach((key, value) -> {
            StringBuilder lineBuilder = new StringBuilder();
            lineBuilder.append(key)
                    .append(splitter)
                    .append(value)
                    .append(System.lineSeparator());
            reportBuilder.append(lineBuilder);
        });
        return reportBuilder.toString();
    }
}
