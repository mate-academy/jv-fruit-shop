package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String HEADERS = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        Storage.getData().entrySet().stream()
                .forEach(totalFruits -> report.append(totalFruits.getKey().getName()
                        + COMMA + totalFruits.getValue()
                        + System.lineSeparator()));
        return HEADERS + System.lineSeparator() + report;
    }
}
