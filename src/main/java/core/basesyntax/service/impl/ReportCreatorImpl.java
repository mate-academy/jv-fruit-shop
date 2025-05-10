package core.basesyntax.service.impl;

import static java.lang.System.lineSeparator;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry :
                FruitStorage.getFruitInventory().entrySet()) {
            report.append(lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
