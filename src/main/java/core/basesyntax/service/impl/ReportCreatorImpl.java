package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEAD = "fruit,amount";
    private static final String SPLITTER = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(HEAD);
        for (Map.Entry<String, Integer> line : FruitStorage.fruitStorage.entrySet()) {
            report.append(System.lineSeparator())
                    .append(line.getKey())
                    .append(SPLITTER)
                    .append(line.getValue());
        }
        return report.toString();
    }
}
