package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String TITLE = "fruit,quantity";
    private static final String COMA = ",";

    @Override
    public String createReport(Map<String, Integer> resume) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : resume.entrySet()) {
            stringBuilder.append(entry.getKey()).append(COMA)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
