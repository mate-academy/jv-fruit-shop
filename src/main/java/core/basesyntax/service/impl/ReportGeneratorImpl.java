package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder(REPORT_HEADER);

        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return builder.toString();
    }
}
