package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDatabase;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        String firstLineReport = "fruit, quantity" + System.lineSeparator();
        report.append(firstLineReport);
        Map<String, Integer> databaseMap = FruitDatabase.database;
        databaseMap.entrySet().stream()
                .map(entry ->
                        entry.getKey() + "," + entry.getValue() + System.lineSeparator())
                .forEach(report::append);
        return report.toString();
    }
}
