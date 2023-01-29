package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class ReportsServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        Storage.fruits.entrySet().stream()
                .forEach(f -> report.append(f.getKey()).append(",")
                        .append(f.getValue()).append(System.lineSeparator()));
        return report.toString();
    }
    
}
