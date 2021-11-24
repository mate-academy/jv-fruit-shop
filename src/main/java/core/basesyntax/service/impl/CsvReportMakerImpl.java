package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportMaker;
import java.util.Map;

public class CsvReportMakerImpl implements ReportMaker {
    private static final String HEAD_OF_REPORT = "fruit,quantity";

    @Override
    public String makeReport(Map<Fruit, Integer> fruits) {
        StringBuilder reportBuilder = new StringBuilder(HEAD_OF_REPORT);
        for (Map.Entry<Fruit, Integer> entry : fruits.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
