package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransaction;
import core.basesyntax.service.FruitShop;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopImpl implements FruitShop {
    public static final int OPERATION_TYPE_ROW = 0;
    public static final int FRUIT_NAME_ROW = 1;
    public static final int QUANTITY_ROW = 2;
    private static final int AMOUNT_DEFAULT_VALUE = 0;
    private final OperationStrategy operationStrategy;
    private final FruitTransaction fruitTransaction;

    public FruitShopImpl(OperationStrategy operationStrategy, FruitTransaction fruitTransaction) {
        this.operationStrategy = operationStrategy;
        this.fruitTransaction = fruitTransaction;
    }

    @Override
    public Map<String, Integer> report(List<List<String>> parsed) {
        if (parsed == null) {
            throw new RuntimeException("None of the arguments must be null");
        }
        Map<String, Integer> result = new HashMap<>();
        parsed.forEach(row -> {
            FruitTransaction.Operation operationType
                    = fruitTransaction.getOperation(row.get(OPERATION_TYPE_ROW));
            String fruitName = row.get(FRUIT_NAME_ROW);
            int quantity = Integer.parseInt(row.get(QUANTITY_ROW));
            int amount = result.getOrDefault(fruitName, AMOUNT_DEFAULT_VALUE);
            result.put(fruitName, operationStrategy.get(operationType).operation(amount, quantity));
        });
        return result;
    }
}
