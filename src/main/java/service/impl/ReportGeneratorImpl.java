package service.impl;

import db.Storage;
import service.ReportGenerator;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private final Storage storage;
    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        Map<String, Integer> fruits = storage.getAllFruits();

        report.append("fruit,amount\n");
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }

        return report.toString();
    }
}
