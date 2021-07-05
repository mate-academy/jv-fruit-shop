package service;

import db.Storage;
import java.util.Map;
import model.Fruit;

public class ReportServiceImpl implements ReportService {
    @Override
    public String makeReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
