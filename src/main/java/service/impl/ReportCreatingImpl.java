package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportCreating;

public class ReportCreatingImpl implements ReportCreating {
    public static final String SEPARATE = "fruit, quantity";
    public static final String COMMA = ",";

    @Override
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder(SEPARATE + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            reportBuilder.append(entry.getKey()).append(COMMA)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
