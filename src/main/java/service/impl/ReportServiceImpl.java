package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : Storage.fruits.entrySet()) {
            reportBuilder.append(fruit.getKey()).append(COMMA_SEPARATOR)
                    .append(fruit.getValue()).append(System.lineSeparator());
        }
        return reportBuilder.toString().trim();
    }
}
