package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport(Storage storage) {
        StringBuilder report = new StringBuilder("fruit,quantity");
        storage.getFruits().forEach((key, val) -> report.append(System.lineSeparator())
                .append(key)
                .append(",")
                .append(val));
        return report.toString();
    }
}
