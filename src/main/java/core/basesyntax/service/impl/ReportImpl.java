package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Report;
import java.util.Map;

public class ReportImpl implements Report {
    @Override
    public String formReport() {
        StringBuilder result = new StringBuilder();
        result.append("fruit,quantity\n");
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            result.append(entry.getKey().getFruitName()).append(",")
                    .append(entry.getValue().toString()).append("\n");
        }
        return result.toString();
    }
}
