package service;

import db.Storage;
import model.Fruit;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_ROW = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(FIRST_ROW)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> report : Storage.storage.entrySet()) {
            stringBuilder.append(report.getKey())
                    .append(",")
                    .append(report.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
