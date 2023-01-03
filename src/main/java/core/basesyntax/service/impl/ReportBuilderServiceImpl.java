package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportBuilderService;
import java.util.Map;

public class ReportBuilderServiceImpl implements ReportBuilderService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String buildReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
