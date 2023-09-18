package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportCreatorService;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String DEFAULT_MESSAGE = "fruit,quantity";
    private static final String SPLIT_DELIMITER = ",";
    private final StringBuilder reportBuilder = new StringBuilder();

    @Override
    public String createReport() {
        reportBuilder.append(DEFAULT_MESSAGE).append(System.lineSeparator());
        Storage.STORAGE.forEach((key, value) -> reportBuilder.append(key)
                .append(SPLIT_DELIMITER)
                .append(value)
                .append(System.lineSeparator()));
        return reportBuilder.toString();
    }
}
