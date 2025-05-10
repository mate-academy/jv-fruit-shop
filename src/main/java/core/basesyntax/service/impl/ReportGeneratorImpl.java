package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String TITLE = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> lot : Storage.getStoredFruits().entrySet()) {
            stringBuilder.append(lot.getKey() + DELIMITER + lot.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
