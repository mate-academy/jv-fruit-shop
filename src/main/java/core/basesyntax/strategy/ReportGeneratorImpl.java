package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Storage storage) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");
        for(Map.Entry<String, Integer> entry : storage.getInventory().entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}
