package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String TITLE_REPORT = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final Storage storage = Storage.getInstance(); // используй Singleton

    @Override
    public String generateReport() {
        StringBuilder finalReport = new StringBuilder(TITLE_REPORT).append(LINE_SEPARATOR);
        storage.getAll().forEach((fruit, quantity) ->
                finalReport.append(fruit)
                        .append(SEPARATOR)
                        .append(quantity)
                        .append(LINE_SEPARATOR));
        return finalReport.toString();
    }
}
