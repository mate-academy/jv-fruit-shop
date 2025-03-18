package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String HEADER = "fruit,quantity";

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            sb.append(HEADER).append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
