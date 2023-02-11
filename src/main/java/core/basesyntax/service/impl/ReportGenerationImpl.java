package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGenerationImpl implements ReportGenerator {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String CSV_COLUMNS_SPLITTER = ",";

    @Override
    public String generateReport(Map<Fruit,Integer> map) {
        StringBuilder contentToWrite = new StringBuilder();
        contentToWrite.append(FIRST_LINE)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit,Integer> entry : map.entrySet()) {
            contentToWrite.append(entry.getKey().getName())
                    .append(CSV_COLUMNS_SPLITTER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return contentToWrite.toString();
    }
}
