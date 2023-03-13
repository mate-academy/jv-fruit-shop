package service.impl;

import db.Storage;
import java.util.Map;

public class CreateReportService implements service.CreateReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(TITLE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.FRUITS.entrySet()) {
            builder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
