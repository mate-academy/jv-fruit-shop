package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitTransactionHandler;
import core.basesyntax.strategy.FruitTransactionStrategy;
import java.util.HashMap;
import java.util.Map;

public class FruitTransactionStrategyImpl implements FruitTransactionStrategy {
    private static final Map<FruitTransaction.Operation,
            FruitTransactionHandler> transactionStrategyMap;

    static {
        transactionStrategyMap = new HashMap<>();
        transactionStrategyMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        transactionStrategyMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        transactionStrategyMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        transactionStrategyMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
    }

    @Override
    public FruitTransactionHandler getTransaction(FruitTransaction.Operation operation) {
        return transactionStrategyMap.get(operation);
    }
}
