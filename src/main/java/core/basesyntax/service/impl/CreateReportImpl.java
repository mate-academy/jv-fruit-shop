package core.basesyntax.service.impl;

import core.basesyntax.service.CreateReport;
import java.util.Map;

public class CreateReportImpl implements CreateReport {
    private static final String TITLE = "fruit,quantity";
    private static final String LINE_BREAK = "\n";
    private static final String COMA = ",";

    @Override
    public String writeReport(Map<String, Integer> resume) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE).append(LINE_BREAK);
        for (Map.Entry<String, Integer> entry : resume.entrySet()) {
            String fruit = entry.getKey();
            int amount = entry.getValue();
            stringBuilder.append(fruit).append(COMA).append(amount).append(LINE_BREAK);
        }
        return stringBuilder.toString();
    }
}
