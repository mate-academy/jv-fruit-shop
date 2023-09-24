package core.basesyntax.service.impl;

import core.basesyntax.model.FruitShopOperation;
import core.basesyntax.service.interfaces.TransactionStrategy;
import core.basesyntax.service.transaction.TransactionHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<FruitShopOperation, TransactionHandler> transactionsHandlers;

    public TransactionStrategyImpl(
            Map<FruitShopOperation, TransactionHandler> transactionsHandlersMap) {
        this.transactionsHandlers = transactionsHandlersMap;
    }

    @Override
    public TransactionHandler get(FruitShopOperation fruitShopOperation) {
        return transactionsHandlers.get(fruitShopOperation);
    }
}
