package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEAD = "fruit,quantity";
    private static final String JOINER = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEAD).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : Storage.getFruits().entrySet()) {
            report.append(fruit.getKey()).append(JOINER).append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
