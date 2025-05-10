package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String TITLE_REPORT = "fruit,quantity";

    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String generateReport() {
        StringBuilder finalReport = new StringBuilder(TITLE_REPORT).append(System.lineSeparator());
        storage.getAll().forEach((fruit, quantity) ->
                finalReport.append(fruit)
                        .append(SEPARATOR)
                        .append(quantity)
                        .append(System.lineSeparator()));
        return finalReport.toString();
    }
}
