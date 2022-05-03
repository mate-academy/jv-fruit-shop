package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport(Map<Fruit, Integer> database) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,").append("quantity").append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : database.entrySet()) {
            report.append(entry.getKey().getName()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
