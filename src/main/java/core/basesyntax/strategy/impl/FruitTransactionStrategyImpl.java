package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitTransactionHandler;
import core.basesyntax.strategy.FruitTransactionStrategy;
import java.util.HashMap;
import java.util.Map;

public class FruitTransactionStrategyImpl implements FruitTransactionStrategy {
    private static final Map<String, FruitTransactionHandler> transactionStrategyMap;

    static {
        transactionStrategyMap = new HashMap<>();
        transactionStrategyMap.put("b", new BalanceHandler());
        transactionStrategyMap.put("s", new SupplyHandler());
        transactionStrategyMap.put("p", new PurchaseHandler());
        transactionStrategyMap.put("r", new ReturnHandler());
    }

    @Override
    public FruitTransactionHandler getTransaction(String transaction) {
        return transactionStrategyMap.get(transaction);
    }
}
