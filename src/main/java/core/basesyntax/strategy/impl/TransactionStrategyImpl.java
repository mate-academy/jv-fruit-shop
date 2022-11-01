package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.handlers.impl.SaveTransactionHandler;
import core.basesyntax.handlers.impl.RemoveTransactionHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.HashMap;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, TransactionHandler> strategyMap;

    public TransactionStrategyImpl(FruitStorage storage) {
        this.strategyMap = new HashMap<>();
        TransactionHandler saveHandler = new SaveTransactionHandler(storage);
        TransactionHandler removeHandler = new RemoveTransactionHandler(storage);
        strategyMap.put(FruitTransaction.Operation.BALANCE, saveHandler);
        strategyMap.put(FruitTransaction.Operation.RETURN, saveHandler);
        strategyMap.put(FruitTransaction.Operation.PURCHASE, removeHandler);
        strategyMap.put(FruitTransaction.Operation.SUPPLY, saveHandler);
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation operation) {
        return strategyMap.get(operation);
    }
}
