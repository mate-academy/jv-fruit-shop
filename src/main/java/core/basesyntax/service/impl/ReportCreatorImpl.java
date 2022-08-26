package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import java.util.Map;
import java.util.Set;

public class ReportCreatorImpl implements ReportCreator {
    private static final String TITLE_ROW = "type,fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String createReport(Map<String, Integer> data) {
        Set<String> fruits = data.keySet();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE_ROW);
        for (String fruit : fruits) {
            reportBuilder.append(fruit)
                    .append(COMMA)
                    .append(data.get(fruit))
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
