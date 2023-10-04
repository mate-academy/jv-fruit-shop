package core.basesyntax.service.transactions;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.interfaces.strategy.TransactionHandler;
import core.basesyntax.service.interfaces.strategy.TransactionStrategy;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, TransactionHandler> handlerMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation, TransactionHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

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
