package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbWithHeader = sb.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            sbWithHeader.append(entry.getKey()).append(COMMA)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return sbWithHeader.toString();
    }
}
