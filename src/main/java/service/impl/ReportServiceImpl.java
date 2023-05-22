package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit").append(",").append("quantity");
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey()).append(",").append(entry.getValue());
        }
        return builder.toString();
    }
}
