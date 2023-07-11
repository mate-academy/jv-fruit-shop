package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruitEntry : Storage.FRUIT_STORAGE.entrySet()) {
            stringBuilder.append(fruitEntry.getKey())
                    .append(COMMA)
                    .append(fruitEntry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
