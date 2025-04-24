package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String REGEX_TO_SPLIT = ",";
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(HEADER).append(System.lineSeparator());
        storage.getAll().forEach((key, value) -> builder.append(key)
                .append(REGEX_TO_SPLIT)
                .append(value)
                .append(System.lineSeparator()));
        return builder.toString();
    }
}
