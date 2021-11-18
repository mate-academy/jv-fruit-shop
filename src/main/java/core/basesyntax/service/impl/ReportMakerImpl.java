package core.basesyntax.service.impl;

import core.basesyntax.service.ReportMaker;
import java.util.Map;

public class ReportMakerImpl implements ReportMaker {
    private static final String HEAD_OF_REPORT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String makingReport(Map<String, Long> totalAmount) {
        StringBuilder reportBuilder = new StringBuilder(HEAD_OF_REPORT);
        for (Map.Entry<String, Long> entry : totalAmount.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
