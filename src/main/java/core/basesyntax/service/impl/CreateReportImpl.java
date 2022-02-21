package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CreateReport;
import java.util.Map;

public class CreateReportImpl implements CreateReport {
    private static final String HEAD_OF_FILE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEAD_OF_FILE);
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
