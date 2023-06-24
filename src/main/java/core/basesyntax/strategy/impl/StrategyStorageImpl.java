package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.StrategyStorage;
import java.util.Map;

public class StrategyStorageImpl implements StrategyStorage {
    private Map<FruitTransaction.Operation, OperationHandler> handlers;

    public void setHandlers(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public Map<FruitTransaction.Operation, OperationHandler> getHandlers() {
        return handlers;
    }

    @Override
    public OperationHandler getStrategy(FruitTransaction fruitTransaction) {
        return handlers.get(fruitTransaction.getOperation());
    }
}
