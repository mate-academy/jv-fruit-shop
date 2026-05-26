package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder("fruit,quantity").append("\n");
        for (Map.Entry<String, FruitTransaction> item : Storage.fruitTransactions.entrySet()) {
            sb.append(item.getKey()).append(",").append(item.getValue().getQuantity()).append("\n");
        }
        return sb.toString();
    }
}
