package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String TEMPLATE = "fruit,quantity\n";

    @Override
    public String createReport(List<FruitTransaction> fruitTransactions) {
        StringBuilder data = new StringBuilder(TEMPLATE);
        for (FruitTransaction fruit : fruitTransactions) {
            data.append(fruit.getFruit()).append(",").append(fruit.getQuantity()).append("\n");
        }
        return data.toString();
    }
}
