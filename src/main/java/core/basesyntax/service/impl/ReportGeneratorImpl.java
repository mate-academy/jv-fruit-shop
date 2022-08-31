package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String DATA_SEPARATOR = ",";

    @Override
    public String makeReport() {
        StringBuilder report = new StringBuilder()
                .append(HEADER).append(System.lineSeparator());

        for (Map.Entry<String, Integer> pair : Storage.storage.entrySet()) {
            report.append(pair.getKey()).append(DATA_SEPARATOR)
                    .append(pair.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
