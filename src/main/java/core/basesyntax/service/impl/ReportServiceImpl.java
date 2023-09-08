package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,balance";
    private static final String COMMA = ",";

    @Override
    public String makeReport(Map<Fruit, Integer> data) {
        StringBuilder stringBuilder = new StringBuilder(REPORT_TITLE)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : data.entrySet()) {
            stringBuilder.append(entry.getKey().getName())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
