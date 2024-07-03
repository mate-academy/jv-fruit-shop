package core.basesyntax.service;

import core.basesyntax.db.DataBase;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit, quantity");
        for (Map.Entry<String, Integer> entry : DataBase.storage.entrySet()) {
            report.append("\n");
            report.append(entry.getKey()).append(",").append(entry.getValue());
        }
        return report.toString();
    }
}
