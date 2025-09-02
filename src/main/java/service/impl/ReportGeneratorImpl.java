package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String COLUMN_NAMES = "fruit,quantity";
    public static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(COLUMN_NAMES).append(System.lineSeparator());
        Map<String,Integer> map = Storage.getAllItems();
        if (!map.isEmpty()) {
            for (Map.Entry<String,Integer> entry : map.entrySet()) {
                builder.append(entry.getKey())
                        .append(SEPARATOR)
                        .append(entry.getValue())
                        .append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
