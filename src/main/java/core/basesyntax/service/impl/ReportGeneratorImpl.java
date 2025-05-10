package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String BASE_REPORT_FIELDS = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(BASE_REPORT_FIELDS)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.getInventory().entrySet()) {
            report.append(entry.getKey())
                    .append(COMMA_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
