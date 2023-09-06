package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    public static final String COMA = ",";
    public static final String FRUIT = "fruit";
    public static final String QUANTITY = "quantity";

    @Override
    public String createReport(Storage storage) {
        StringBuilder report = new StringBuilder();
        report.append(FRUIT).append(COMA).append(QUANTITY);
        storage.getData().forEach((k, v) -> {
            report.append(System.lineSeparator());
            report.append(k).append(COMA).append(v);
        });
        return report.toString();
    }
}
