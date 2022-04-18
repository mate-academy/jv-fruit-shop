package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String createReport(Map<Fruit, Integer> fruitStorage) {
        StringBuilder stringBuilder = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<Fruit, Integer> entry : fruitStorage.entrySet()) {
            stringBuilder
                    .append(LINE_SEPARATOR)
                    .append(entry.getKey().getName())
                    .append(COMMA)
                    .append(entry.getValue());
        }

        return stringBuilder.toString();

    }
}
