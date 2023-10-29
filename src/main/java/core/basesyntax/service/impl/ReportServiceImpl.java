package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {

    public static final String REPORT_HEADER = "fruit,quantity";
    public static final char SPLITERATOR = ',';

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder()
                .append(REPORT_HEADER).append(System.lineSeparator());
        Storage.DATABASE.forEach((key, value) -> report.append(key)
                .append(SPLITERATOR).append(value).append(System.lineSeparator()));
        return report.toString();
    }
}
