package core.basesyntax.service;

import core.basesyntax.db.Inventory;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Inventory inventory) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : inventory.getInventory().entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
