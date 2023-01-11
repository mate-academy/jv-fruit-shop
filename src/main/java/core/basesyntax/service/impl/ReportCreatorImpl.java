package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String SPLITTER = ",";
    private static final String HEADER = "fruit,amount";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> element : Storage.fruitMap.entrySet()) {
            builder.append(element.getKey())
                    .append(SPLITTER)
                    .append(element.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
