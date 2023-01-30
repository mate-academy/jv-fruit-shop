package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportsServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> f : Storage.fruits.entrySet()) {
            report.append(f.getKey()).append(",")
                    .append(f.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
