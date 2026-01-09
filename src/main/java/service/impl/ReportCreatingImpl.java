package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportCreating;

public class ReportCreatingImpl implements ReportCreating {
    private static final String SEPARATE = "fruit, quantity";
    private static final String COMMA = ",";
    private final Storage storage;

    public ReportCreatingImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder(SEPARATE + System.lineSeparator());
        Map<String,Integer> data = storage.getAll();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            reportBuilder.append(entry.getKey()).append(COMMA)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
