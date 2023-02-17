package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    public static final String HEAD = "fruit,quantity";

    @Override
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder(HEAD).append("\n");
        for (Map.Entry key : Storage.fruits.entrySet()) {
            reportBuilder.append(key.getKey().toString())
                    .append(",")
                    .append(key.getValue().toString())
                    .append("\n");
        }
        return reportBuilder.toString();
    }
}
