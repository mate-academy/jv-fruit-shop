package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String DELIMITER = ",";
    private static final String REPORT_FILE_HEADER = "fruit,quantity";
    private final Storage storage;

    public ReportCreatorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(REPORT_FILE_HEADER).append(System.lineSeparator());
        report.append(
                storage.getFruitStorage().entrySet().stream()
                        .map(entry -> entry.getKey() + DELIMITER + entry.getValue())
                        .collect(Collectors.joining(System.lineSeparator())));
        return String.valueOf(report);
    }
}
