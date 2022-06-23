package core.basesyntax.service.impl;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String create() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity");
        reportBuilder.append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Warehouse.getWarehouse().entrySet()) {
            reportBuilder.append(entry.getKey().getName());
            reportBuilder.append(",");
            reportBuilder.append(entry.getValue());
            reportBuilder.append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
