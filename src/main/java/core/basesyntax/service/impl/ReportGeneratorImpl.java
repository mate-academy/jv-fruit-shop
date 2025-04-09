package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String TITLE_REPORT = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String generate() {
        Map<String, Integer> reportFromStorage = storage.getFruitTransactionInfo();
        StringBuilder finalReport = new StringBuilder(TITLE_REPORT).append(LINE_SEPARATOR);
        reportFromStorage.forEach((key, val) -> finalReport
                .append(key).append(SEPARATOR).append(val)
                .append(LINE_SEPARATOR));
        return finalReport.toString();
    }
}
