package core.basesyntax.service.transactions;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.interfaces.strategy.TransactionHandler;
import core.basesyntax.service.interfaces.strategy.TransactionStrategy;
import java.util.HashMap;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private static final Map<FruitTransaction.Operation, TransactionHandler> handlerMap =
            new HashMap<>();

    @Override
    public TransactionHandler getTransaction(FruitTransaction.Operation type) {
        return handlerMap.get(type);
    }

    @Override
    public void addToMap(FruitTransaction.Operation operation,
                         TransactionHandler transactionHandler) {
        handlerMap.put(operation, transactionHandler);
    }
}
