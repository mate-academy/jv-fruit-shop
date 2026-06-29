package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.getAllFruits().entrySet()) {
            sb.append(entry.getKey())
                    .append(CSV_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}


