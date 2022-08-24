package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReportCreatorImpl implements ReportCreator {
    private static final String TITLE_ROW = "type,fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public List<String> createReport(Map<String, Integer> data) {
        List<String> report = new ArrayList<>();
        report.add(TITLE_ROW);
        Set<String> fruits = data.keySet();
        for (String fruit : fruits) {
            StringBuilder reportBuilder = new StringBuilder();
            report.add(reportBuilder.append(fruit)
                    .append(COMMA)
                    .append(data.get(fruit))
                    .append(System.lineSeparator())
                    .toString());
        }
        return report;
    }
}
