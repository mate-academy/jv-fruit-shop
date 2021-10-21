package core.basesyntax.service;

import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String COLUMN_NAMES = "fruit,quantity";

    @Override
    public String createReport(Map<String, Integer> fruitQuantityMap) {
        StringBuilder reportContent = new StringBuilder();
        reportContent.append(COLUMN_NAMES);

        for (Map.Entry<String, Integer> itemFruit : fruitQuantityMap.entrySet()) {
            reportContent
                    .append(System.lineSeparator())
                    .append(itemFruit.getKey())
                    .append(FruitParserImpl.SEPARATOR)
                    .append(itemFruit.getValue());

        }
        return reportContent.toString();
    }
}
