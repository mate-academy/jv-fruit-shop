package service.impl;

import db.FruitStorage;
import java.util.Map;
import service.Reporter;

public class FruitReporter implements Reporter {
    private static final String REPORT_HEAD = "fruit,quantity";
    private final FruitStorage fruitStorage;

    public FruitReporter(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_HEAD);
        for (Map.Entry entry : fruitStorage.getFruits().entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
