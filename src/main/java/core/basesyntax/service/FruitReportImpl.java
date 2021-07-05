package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitReportImpl implements FruitReport {
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity");
        for (Map.Entry<Fruit,Integer> line : Storage.getFruits().entrySet()) {
            report.append(System.lineSeparator()).append(line.getKey().getName())
                    .append(SEPARATOR).append(line.getValue());
        }
        return report.toString();
    }
}
