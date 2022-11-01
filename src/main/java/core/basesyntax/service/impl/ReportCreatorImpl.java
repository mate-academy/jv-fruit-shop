package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String REPORT_HEADER = "fruit, quantity";
    private static final String REPORT_LINE_SPLITTER = ",";

    @Override
    public String createReport(Map<Fruit, Integer> storage) {
        StringBuilder dataToWrite = new StringBuilder();
        dataToWrite.append(REPORT_HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            dataToWrite.append(entry.getKey().getType())
                    .append(REPORT_LINE_SPLITTER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return dataToWrite.toString();
    }
}
