package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {

    private static final String FIRST_LINE_REPORT = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(FIRST_LINE_REPORT);
        stringBuilder.append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            stringBuilder
                        .append(entry.getKey())
                        .append(",")
                        .append(entry.getValue())
                        .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
