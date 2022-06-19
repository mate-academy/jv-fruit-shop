package core.basesyntax.service;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.Map;

public interface TransactionParser {
    Transaction.Operation getOperation(String line);

    Fruit getFruit(String line);

    Integer getQuantity(String line);

    class ReportFormatter {

        public String formatReportAsCsvString() {
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
}
