package core.basesyntax.service.impl;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String create() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity\n");
        for (Map.Entry<Fruit, Integer> entry : Warehouse.getWarehouse().entrySet()) {
            stringBuilder.append(entry.getKey().getName());
            stringBuilder.append(",");
            stringBuilder.append(entry.getValue());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
