package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitReportImpl implements FruitReport {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity");
        for (Map.Entry<Fruit,Integer> line : Storage.getFruits().entrySet()) {
            report.append("\n").append(line.getKey().getName())
                    .append(",").append(line.getValue());
        }
        return report.toString();
    }
}
