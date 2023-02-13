package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportConstructor;
import java.util.Map;

public class ReportConstructorImpl implements ReportConstructor {
    private static final String INTRODUCTION = "fruit, quantity";
    private static final String CSV_SPLITTER = ",";

    @Override
    public String createReport(Map<Fruit, Integer> reportMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(INTRODUCTION)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit,Integer> entry : reportMap.entrySet()) {
            stringBuilder.append(entry.getKey().getName())
                    .append(CSV_SPLITTER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

}
