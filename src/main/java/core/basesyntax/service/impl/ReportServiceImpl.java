package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder()
                .append("fruit,quantity").append(System.lineSeparator());
        Storage.DATA_BASE.forEach((key, value) -> report.append(key)
                .append(',').append(value).append(System.lineSeparator()));
        return report.toString();
    }
}
