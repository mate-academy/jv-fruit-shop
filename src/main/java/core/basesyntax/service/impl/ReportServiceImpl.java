package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String TEMPLATE = "fruit,quantity\n";
   private StringBuilder data;

    @Override
    public String createReport(List<FruitTransaction> fruitTransactions) {
        data = new StringBuilder(TEMPLATE);
        for (FruitTransaction fruit : fruitTransactions) {
            data.append(fruit.getFruit()).append(",").append(fruit.getQuantity()).append("\n");
        }
        return data.toString();
    }
}
