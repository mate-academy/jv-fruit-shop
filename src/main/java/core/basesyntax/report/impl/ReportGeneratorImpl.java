package core.basesyntax.report.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.report.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FRUIT_CATEGORY = "fruit,quantity";
    private static final String COMMA = ",";
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(FRUIT_CATEGORY).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.getStorage().entrySet()) {
            report.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
