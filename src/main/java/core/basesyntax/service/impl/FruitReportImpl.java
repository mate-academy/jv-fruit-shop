package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitReport;

import java.util.Map;
import java.util.Set;

public class FruitReportImpl implements FruitReport {
    private static final String REPORT_TITLE = "fruit,balance";
    private static final String SEPARATOR = ",";

    @Override
    public StringBuilder makeReport(Set<Map.Entry<Fruit, Integer>> entrySet) {
        StringBuilder report = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<Fruit, Integer> element : entrySet) {
            report.append(System.lineSeparator())
                    .append(element.getKey().getName())
                    .append(SEPARATOR)
                    .append(element.getValue());
        }
        return report;
    }
}
