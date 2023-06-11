package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";
    private static final String FIRST_LINE_IN_OUTPUT = "fruit,quantity" + System.lineSeparator();
    private OperationStrategy strategy;

    public ReportServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public String createFinalReport(Map<String, Integer> fruitsMap) {
        StringBuilder builder = new StringBuilder(FIRST_LINE_IN_OUTPUT);
        for (Map.Entry<String, Integer> map : fruitsMap.entrySet()) {
            builder.append(map.getKey());
            builder.append(SEPARATOR);
            builder.append(map.getValue());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    @Override
    public void applyTransactionsToStorage(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruit : fruitTransactionList) {
            strategy.get(fruit.getOperation()).applyTransactionToStorage(fruit);
        }
    }
}
