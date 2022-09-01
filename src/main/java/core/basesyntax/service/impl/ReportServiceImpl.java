package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String HEADERS = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(HEADERS).append(System.lineSeparator());
        Storage.getData().entrySet().stream()
                .forEach(totalFruits -> report.append(new StringBuilder(totalFruits.getKey()
                        .getName()).append(COMMA).append(totalFruits.getValue())
                        .append(System.lineSeparator())));
        return report.toString();
    }
}
