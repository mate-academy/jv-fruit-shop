package service.impl;

import db.Storage;
import java.util.Map;
import model.Fruit;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> record : Storage.storage.entrySet()) {
            stringBuilder.append(record.getKey()).append(",")
                    .append(record.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
