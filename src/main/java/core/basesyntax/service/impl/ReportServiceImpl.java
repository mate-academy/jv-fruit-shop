package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String makeReport() {
        StringBuilder stringBuilder = new StringBuilder(FIRST_LINE);
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(COMMA)
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
