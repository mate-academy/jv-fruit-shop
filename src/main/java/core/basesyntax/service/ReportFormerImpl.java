package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.interfaces.ReportFormer;

import java.util.Map;

public class ReportFormerImpl implements ReportFormer {
    private static final String COMA_SEPARATOR = ",";
    private static final String HEADLINE = "fruit,quantity";

    @Override
    public String formReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(HEADLINE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> line : Storage.reportData.entrySet()) {
            builder.append(line.getKey()).append(COMA_SEPARATOR)
                    .append(line.getValue()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
