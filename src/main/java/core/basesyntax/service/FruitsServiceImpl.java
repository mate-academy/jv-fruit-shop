package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitsServiceImpl implements FruitsService {
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";
    private final OperationStrategy operationStrategy;
    private final Map<String, Integer> reportMap = new HashMap<>();

    public FruitsServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> processTransactions(List<FruitTransaction> transactions) {
        reportMap.put(BANANA, 0);
        reportMap.put(APPLE, 0);
        if (transactions.size() == 0) {
            throw new RuntimeException("CSV file is empty!");
        } else {
            for (FruitTransaction transaction: transactions) {
                Integer supply = reportMap.get(transaction.getFruit())
                        + operationStrategy.get(transaction.getOperation())
                                .getOperation(transaction.getQuantity());
                reportMap.put(transaction.getFruit(), supply);
            }
        }
        return reportMap;
    }
}
