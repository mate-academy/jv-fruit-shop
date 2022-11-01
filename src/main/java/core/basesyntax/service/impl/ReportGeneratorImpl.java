package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String CSV_HEADER = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String reportFromStorage(Map<Fruit, Integer> inputMap) {
        StringBuilder infoToWrite = new StringBuilder();
        infoToWrite.append(CSV_HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : inputMap.entrySet()) {
            infoToWrite.append(entry.getKey().getName())
                    .append(COMMA_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return infoToWrite.toString();
    }
}
