package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String VALUES = "fruit, quanity";
    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(VALUES).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
