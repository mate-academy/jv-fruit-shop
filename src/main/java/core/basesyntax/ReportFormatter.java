package core.basesyntax;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class ReportFormatter {

    public static String formatReportAsCsvString() {
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
