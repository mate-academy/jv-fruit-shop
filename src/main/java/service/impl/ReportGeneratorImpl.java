package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());

        for (Map.Entry<String, Integer> pair : Storage.reports.entrySet()) {
            stringBuilder.append(pair.getKey())
                    .append(",")
                    .append(pair.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
