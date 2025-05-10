package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER_GOODS = "fruit";
    private static final String HEADER_QUANTITY = "quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String getReport(Map<String, Integer> reportData) {
        StringBuilder reportString = new StringBuilder();
        for (Map.Entry<String, Integer> entry : reportData.entrySet()) {
            reportString.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return HEADER_GOODS + SEPARATOR + HEADER_QUANTITY + System.lineSeparator()
                + reportString;
    }
}
