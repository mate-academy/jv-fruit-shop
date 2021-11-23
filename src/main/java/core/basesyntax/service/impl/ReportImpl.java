package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Report;
import java.util.Map;

public class ReportImpl implements Report {
    @Override
    public String formReport() {
        String result = "fruit,quantity\n";
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            result += entry.getKey().getFruitName() + "," + entry.getValue().toString() + "\n";
        }
        return result;
    }
}
