package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.BalanceTransaction;
import core.basesyntax.strategy.impl.PurchaseTransaction;
import core.basesyntax.strategy.impl.ReturnTransaction;
import core.basesyntax.strategy.impl.SupplyTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitTransactionStrategy {
    static final Map<String, FruitTransaction> transactionStrategyMap;
    private static final int INDEX_TRANSACTION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final String SEPARATOR = ",";

    static {
        transactionStrategyMap = new HashMap<>();
        transactionStrategyMap.put("b", new BalanceTransaction());
        transactionStrategyMap.put("s", new SupplyTransaction());
        transactionStrategyMap.put("p", new PurchaseTransaction());
        transactionStrategyMap.put("r", new ReturnTransaction());
    }

    public void considerTransactionWithFruit(List<String> fruitConsider) {
        FruitTransaction fruitTransaction;
        for (int i = 1; i < fruitConsider.size(); i++) {
            String[] partsTransaction = fruitConsider.get(i).split(SEPARATOR);
            String transaction = partsTransaction[INDEX_TRANSACTION];
            String fruit = partsTransaction[INDEX_FRUIT];
            int quantity = Integer.parseInt(partsTransaction[INDEX_QUANTITY]);
            fruitTransaction = transactionStrategyMap.get(transaction);
            fruitTransaction.implementTransactionWithFruit(fruit, quantity);
        }
    }
}
