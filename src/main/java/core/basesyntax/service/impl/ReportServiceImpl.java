package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.Set;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,balance";
    private static final String COMMA = ",";

    @Override
    public StringBuilder makeReport(Set<Map.Entry<Fruit, Integer>> entrySet) {
        StringBuilder reportMaker = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<Fruit, Integer> element : entrySet) {
            reportMaker.append(System.lineSeparator())
                    .append(element.getKey().getName())
                    .append(COMMA)
                    .append(element.getValue());
        }
        return reportMaker;
    }
}
