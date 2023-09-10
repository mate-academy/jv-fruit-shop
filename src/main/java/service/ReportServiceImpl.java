package service;

import db.Storage;
import java.util.Map;
import model.Fruit;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String REGEX = ",";

    @Override
    public String makeReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(REGEX)
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
