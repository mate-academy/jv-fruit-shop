package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String STRING_TITLE = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA_DELIMITER = ",";

    @Override
    public String getReport(Map<String, Integer> fruitData) {
        if (fruitData == null) {
            throw new RuntimeException("The fruit storage is null");

        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(STRING_TITLE);

        if (fruitData.isEmpty()) {
            return stringBuilder.toString();
        }

        for (Map.Entry<String, Integer> entry : fruitData.entrySet()) {
            stringBuilder
                    .append(entry.getKey())
                    .append(COMMA_DELIMITER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
