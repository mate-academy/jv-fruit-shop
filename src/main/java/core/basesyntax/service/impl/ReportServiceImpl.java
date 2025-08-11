package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder builder = new StringBuilder(REPORT_HEADER);
        builder.append(System.lineSeparator());
        Storage.fruitStorage.entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .forEach(line -> builder.append(line)
                        .append(System.lineSeparator()));

        return builder.toString();
    }
}
