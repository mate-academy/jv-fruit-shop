package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport(Storage storage) {
        StringBuilder reportBuilder = new StringBuilder(HEADER);

        for (Map.Entry<String, Integer> entry : storage.getAll().entrySet()) {
            reportBuilder
                    .append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }

        return reportBuilder.toString();
    }
}
