package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            builder.append(entry.getKey() + "," + entry.getValue() + System.lineSeparator());
        }
        return builder.toString();
    }
}
