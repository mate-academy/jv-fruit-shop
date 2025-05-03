package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(entry.getKey()).append(COMMA)
                        .append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
