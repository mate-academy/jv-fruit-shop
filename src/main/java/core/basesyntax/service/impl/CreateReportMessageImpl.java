package core.basesyntax.service.impl;

import core.basesyntax.service.CreateReportMessage;
import java.util.Map;

public class CreateReportMessageImpl implements CreateReportMessage {
    private static final String SEPARATOR_TO_WORDS = ",";

    @Override
    public String createMessage(Map<String, Integer> toWrite) {
        StringBuilder toReport = new StringBuilder();
        toReport.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> report : toWrite.entrySet()) {
            toReport.append(report.getKey()).append(SEPARATOR_TO_WORDS)
                    .append(report.getValue()).append(System.lineSeparator());
        }
        return toReport.toString();
    }
}
