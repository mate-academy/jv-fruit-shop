package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,amount";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE = System.lineSeparator();
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        Map<String, Integer> fruits = storage.getAllFruits();

        report.append(HEADER).append(NEW_LINE);
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.append(entry.getKey()).append(COMMA_DELIMITER).append(entry.getValue()).append(NEW_LINE);
        }

        return report.toString();
    }
}
